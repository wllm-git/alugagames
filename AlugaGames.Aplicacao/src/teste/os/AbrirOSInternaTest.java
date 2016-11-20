package teste.os;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.OrdemServicoAplicacao;
import alugagames.core.consoles.Console;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.os.OrdemServicoItem;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.Voltagem;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.ConsoleRepositorio;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class AbrirOSInternaTest {
	private static OrdemServicoAplicacao ordemServicoAplicacao;
	private static Funcionario atendenteAtivo;
	private static Funcionario atendenteInativo;
	private static Console console;
	private static Console consoleInativo;
	private static Console consoleSemAvaria;

	@BeforeClass
	public static void inicializar() {
		
		TipoConsole tipoConsole = new TipoConsole();
		tipoConsole.setNome("PS4 Teste");
		
		console = new Console();
		console.setAtivo(true);
		console.setAno(new Date(106, 1, 1));
		console.setNumeroSerie("123456");
		console.setVoltagem(Voltagem.V_UNI);
		console.setPreco(12.15f);
		console.setTipoConsole(tipoConsole);
		console.setStatus(StatusProduto.Avariado);
		
		consoleInativo = new Console();
		consoleInativo.setAtivo(false);
		consoleInativo.setAno(new Date(106, 1, 1));
		consoleInativo.setNumeroSerie("123457");
		consoleInativo.setVoltagem(Voltagem.V_UNI);
		consoleInativo.setPreco(12.15f);
		consoleInativo.setTipoConsole(tipoConsole);
		consoleInativo.setStatus(StatusProduto.Avariado);
		
		consoleSemAvaria = new Console();
		consoleSemAvaria.setAtivo(true);
		consoleSemAvaria.setAno(new Date(106, 1, 1));
		consoleSemAvaria.setNumeroSerie("123458");
		consoleSemAvaria.setVoltagem(Voltagem.V_UNI);
		consoleSemAvaria.setPreco(12.15f);
		consoleSemAvaria.setTipoConsole(tipoConsole);
		consoleSemAvaria.setStatus(StatusProduto.Disponivel);
		
		atendenteAtivo= new Funcionario();
		atendenteAtivo.setFuncao(Funcao.Atendente);
		atendenteAtivo.setAtivo(true);
		
		atendenteInativo= new Funcionario();
		atendenteInativo.setFuncao(Funcao.Atendente);
		atendenteInativo.setAtivo(false);
		
		ConnectionManager.beginTransaction();
		new FuncionarioRepositorio().adicionar(atendenteAtivo);
		new FuncionarioRepositorio().adicionar(atendenteInativo);
		new TipoConsoleRepositorio().adicionar(tipoConsole);
		new ConsoleRepositorio().adicionar(console);
		new ConsoleRepositorio().adicionar(consoleInativo);
		new ConsoleRepositorio().adicionar(consoleSemAvaria);
		ConnectionManager.commit();
		//ConnectionManager.dispose();

		ordemServicoAplicacao = new OrdemServicoAplicacao();
	}
	
	@Test
	public void abrirOSInternaOK() {
		try {
			List<OrdemServicoItem> itens = new ArrayList<OrdemServicoItem>();
			
			OrdemServicoItem item = new OrdemServicoItem();
			item.setDescricao(console.getTipoConsole().getNome());
			item.setNumeroSerie(console.getNumeroSerie());
			
			itens.add(item);
			
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, itens);

			if(!erros.isEmpty())
				Assert.fail();

		} catch (Exception e) {
			Assert.fail();
		}
	}
		
	@Test
	public void abrirOSInternaSemItens() {
		try {
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, new ArrayList<OrdemServicoItem>());
			
			Assert.assertTrue(erros.contains("Não foi informado itens."));
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOSInternaComItemInativo() {
		try {
			List<OrdemServicoItem> itens = new ArrayList<OrdemServicoItem>();
			
			OrdemServicoItem item = new OrdemServicoItem();
			item.setDescricao(consoleInativo.getTipoConsole().getNome());
			item.setNumeroSerie(consoleInativo.getNumeroSerie());
			
			itens.add(item);
			
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, itens);

			Assert.assertTrue(erros.contains("Produto " + item.getDescricao() + " série " + item.getNumeroSerie() + " está inativo."));
		} catch (RuntimeException e) {
			Assert.fail();
		}

	}
	
	@Test
	public void abrirOSInternaComItemSemAvaria() {
		try {
			List<OrdemServicoItem> itens = new ArrayList<OrdemServicoItem>();
			
			OrdemServicoItem item = new OrdemServicoItem();
			item.setDescricao(consoleSemAvaria.getTipoConsole().getNome());
			item.setNumeroSerie(consoleSemAvaria.getNumeroSerie());
			
			itens.add(item);
			
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, itens);

			Assert.assertTrue(erros.contains("Produto " + item.getDescricao() + " série " + item.getNumeroSerie() + " não está avariado."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOSInternaSemAtendente() {
		try {
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(null, new ArrayList<OrdemServicoItem>());

			Assert.assertTrue(erros.contains("Atendente não informado."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOSInternaComAtendenteNaoCadastrado() {
		try {
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(new Funcionario(), new ArrayList<OrdemServicoItem>());

			Assert.assertTrue(erros.contains("Atendente informado não cadastrado no sistema."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOSInternaComAtendenteInativo() {
		try {
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(atendenteInativo, new ArrayList<OrdemServicoItem>());

			Assert.assertTrue(erros.contains("Atendente inválido."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@AfterClass
	public static void fecharConexao(){
		excluirConsole();
		ConnectionManager.dispose();
	}
	
	private static void excluirConsole(){
		ConnectionManager.beginTransaction();
		ConsoleRepositorio repositorio = new ConsoleRepositorio();
		Console c = repositorio.buscarPorID(console.getId());
		repositorio.excluir(c);
		c = repositorio.buscarPorID(consoleInativo.getId());
		repositorio.excluir(c);
		c = repositorio.buscarPorID(consoleSemAvaria.getId());
		repositorio.excluir(c);
		ConnectionManager.commit();
	}
}
