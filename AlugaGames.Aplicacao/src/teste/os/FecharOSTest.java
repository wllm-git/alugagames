package teste.os;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.OrdemServicoAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.StatusOS;
import alugagames.core.os.StatusOSItem;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.OrdemServicoRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class FecharOSTest {
	private static OrdemServicoAplicacao ordemServicoAplicacao;
	private static OrdemServico os;
	private static Cliente cliente;
	private static Funcionario atendente;
	private static Funcionario atendenteInativo;
	private static TipoConsole tipoConsole;
	private static Funcionario tecnicoAtivo;
	private static Funcionario tecnicoInativo;
	
	@BeforeClass
	public static void inicializar() {
		cliente = new Cliente();
		
		tipoConsole = new TipoConsole();
		tipoConsole.setNome("PS4 Teste");
		
		atendente= new Funcionario();
		atendente.setFuncao(Funcao.Atendente);
		atendente.setAtivo(true);
		
		atendenteInativo= new Funcionario();
		atendenteInativo.setFuncao(Funcao.Atendente);
		atendenteInativo.setAtivo(false);
		
		tecnicoAtivo = new Funcionario();
		tecnicoAtivo.setFuncao(Funcao.Tecnico);
		tecnicoAtivo.setAtivo(true);
		
		tecnicoInativo = new Funcionario();
		tecnicoInativo.setFuncao(Funcao.Tecnico);
		tecnicoInativo.setAtivo(false);
		
		OrdemServicoRepositorio repositorio = new OrdemServicoRepositorio();
		
		os = new OrdemServico();
		os.setCliente(cliente);
		os.setDataAbertura(new Date());
		os.setInterna(false);
		os.setOrcamento(null);
		os.setStatus(StatusOS.Aguardando);
		os.setDescricao("Descrição dos problemas.");
		os.setValor(45.47);
		os.setCodigo(repositorio.getNextCodigo());
		List<OrdemServicoItem> itens = new ArrayList<OrdemServicoItem>();
		OrdemServicoItem itemOS = new OrdemServicoItem();
		itemOS.setNumeroSerie("2515236");
		itemOS.setDescricao(tipoConsole.getNome());
		itemOS.setStatusOSItem(StatusOSItem.OK);
		itemOS.setOrdemServico(os);
		itemOS.setValor(45.47);
		itens.add(itemOS);
		os.setTecnico(tecnicoAtivo);
		os.setOrdemServicoItens(itens);
				
		ConnectionManager.beginTransaction();
		new ClienteRepositorio().adicionar(cliente);
		new FuncionarioRepositorio().adicionar(atendente);
		new FuncionarioRepositorio().adicionar(atendenteInativo);
		new FuncionarioRepositorio().adicionar(tecnicoAtivo);
		new FuncionarioRepositorio().adicionar(tecnicoInativo);
		new TipoConsoleRepositorio().adicionar(tipoConsole);
		repositorio.adicionar(os);
		ConnectionManager.commit();
		
		ordemServicoAplicacao = new OrdemServicoAplicacao();
	}
	
	@Before
	public void removerAtendenteOS() {
		os.setAtendente(null);
	}
	
	@Test
	public void FecharOSOK() {
		try {
			
			OrdemServicoRepositorio repositorio = new OrdemServicoRepositorio();
			
			OrdemServico os = new OrdemServico();
			os.setCliente(cliente);
			os.setDataAbertura(new Date());
			os.setInterna(false);
			os.setOrcamento(null);
			os.setStatus(StatusOS.Aguardando);
			os.setDescricao("Descrição dos problemas.");
			os.setValor(45.47);
			os.setCodigo(repositorio.getNextCodigo());		
			List<OrdemServicoItem> itens = new ArrayList<OrdemServicoItem>();			
			OrdemServicoItem itemOS = new OrdemServicoItem();		
			itemOS.setNumeroSerie("2515236");
			itemOS.setDescricao(tipoConsole.getNome());
			itemOS.setStatusOSItem(StatusOSItem.OK);
			itemOS.setOrdemServico(os);
			itemOS.setValor(45.47);
			itens.add(itemOS);		
			os.setOrdemServicoItens(itens);
			os.setTecnico(tecnicoAtivo);
			os.setAtendente(atendente);
			repositorio.adicionar(os);
			
			List<String> erros = ordemServicoAplicacao.fecharOS(os);

			if(!erros.isEmpty())
				Assert.fail();

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void FecharOSInexistente() {
		try {
			OrdemServico os = new OrdemServico(); 
			os.setCodigo(25);
			
			List<String> erros = ordemServicoAplicacao.fecharOS(os);

			Assert.assertTrue(erros.contains("Ordem de serviço " + os.getCodigo() + " não existe no sistema."));
		} catch (RuntimeException e) {
			Assert.fail();
		}

	}
	
	@Test
	public void FecharOSNaoAguardando() {
		try {
			
			OrdemServicoRepositorio repositorio = new OrdemServicoRepositorio();
			
			OrdemServico os = new OrdemServico();
			os.setCliente(cliente);
			os.setDataAbertura(new Date());
			os.setInterna(false);
			os.setOrcamento(null);
			os.setStatus(StatusOS.Aberta);
			os.setDescricao("Descrição dos problemas.");
			os.setValor(45.47);
			os.setCodigo(repositorio.getNextCodigo());		
			List<OrdemServicoItem> itens = new ArrayList<OrdemServicoItem>();			
			OrdemServicoItem itemOS = new OrdemServicoItem();		
			itemOS.setNumeroSerie("2515236");
			itemOS.setDescricao(tipoConsole.getNome());
			itemOS.setStatusOSItem(StatusOSItem.OK);
			itemOS.setOrdemServico(os);
			itemOS.setValor(45.47);		
			itens.add(itemOS);		
			os.setOrdemServicoItens(itens);
			repositorio.adicionar(os);
			
			
			List<String> erros = ordemServicoAplicacao.fecharOS(os);

			Assert.assertTrue(erros.contains("Ordem de serviço "+ os.getCodigo() +" não está aguardando fechamento."));
		} catch (RuntimeException e) {
			Assert.fail();
		}

	}
	
	@Test
	public void FecharOSInternaSemAtendente() {
		try {
			os.setAtendente(null);
			List<String> erros = ordemServicoAplicacao.fecharOS(os);

			Assert.assertTrue(erros.contains("Atendente não informado."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void FecharOSInternaComAtendenteNaoCadastrado() {
		try {
			os.setAtendente(new Funcionario());
			List<String> erros = ordemServicoAplicacao.fecharOS(os);

			Assert.assertTrue(erros.contains("Atendente informado não cadastrado no sistema."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void FecharOSInternaComAtendenteInativo() {
		try {
			os.setAtendente(atendenteInativo);
			List<String> erros = ordemServicoAplicacao.fecharOS(os);

			Assert.assertTrue(erros.contains("Atendente inválido."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
