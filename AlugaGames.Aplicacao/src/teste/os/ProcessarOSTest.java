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

public class ProcessarOSTest {
	private static OrdemServicoAplicacao ordemServicoAplicacao;
	private static OrdemServico os;
	private static Cliente cliente;
	private static Funcionario atendente;
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
		os.setStatus(StatusOS.Fechada);
		os.setDescricao("Descrição dos problemas.");
		os.setValor(45.47);
		os.setCodigo(repositorio.getNextCodigo());		
		List<OrdemServicoItem> itens = new ArrayList<OrdemServicoItem>();			
		OrdemServicoItem itemOS = new OrdemServicoItem();		
		itemOS.setNumeroSerie("2515236");
		itemOS.setDescricao(tipoConsole.getNome());
		itemOS.setStatusOSItem(StatusOSItem.Recebido);
		itemOS.setOrdemServico(os);
		itemOS.setValor(45.47);		
		itens.add(itemOS);		
		os.setOrdemServicoItens(itens);
				
		ConnectionManager.beginTransaction();
		new ClienteRepositorio().adicionar(cliente);
		new FuncionarioRepositorio().adicionar(atendente);
		new FuncionarioRepositorio().adicionar(tecnicoAtivo);
		new FuncionarioRepositorio().adicionar(tecnicoInativo);
		new TipoConsoleRepositorio().adicionar(tipoConsole);
		repositorio.adicionar(os);
		ConnectionManager.commit();
		
		ordemServicoAplicacao = new OrdemServicoAplicacao();
	}
	
	@Before
	public void removerTecnicoOS() {
		os.setTecnico(null);
	}
	
	@Test
	public void processarOSOK() {
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
			itemOS.setStatusOSItem(StatusOSItem.Recebido);
			itemOS.setOrdemServico(os);
			itemOS.setValor(45.47);		
			itens.add(itemOS);		
			os.setOrdemServicoItens(itens);
			repositorio.adicionar(os);
			
			os.setTecnico(tecnicoAtivo);
			
			List<String> erros = ordemServicoAplicacao.processarOS(os);

			if(!erros.isEmpty())
				Assert.fail();

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void processarOSInexistente() {
		try {
			OrdemServico os = new OrdemServico(); 
			os.setCodigo(25);
			
			List<String> erros = ordemServicoAplicacao.processarOS(os);

			Assert.assertTrue(erros.contains("Ordem de serviço " + os.getCodigo() + " não existe no sistema."));
		} catch (RuntimeException e) {
			Assert.fail();
		}

	}
	
	@Test
	public void processarOSNaoAberta() {
		try {
			
			List<String> erros = ordemServicoAplicacao.processarOS(os);

			Assert.assertTrue(erros.contains("Ordem de serviço " + os.getCodigo() + " não está aberta."));
		} catch (RuntimeException e) {
			Assert.fail();
		}

	}
	
	@Test
	public void processarOSSemTecnico() {
		try {
			os.setTecnico(null);
			List<String> erros = ordemServicoAplicacao.processarOS(os);

			Assert.assertTrue(erros.contains("Técnico não informado."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void processarOSComTecnicoNaoCadastrado() {
		try {
			os.setTecnico(new Funcionario());
			List<String> erros = ordemServicoAplicacao.processarOS(os);

			Assert.assertTrue(erros.contains("Técnico informado não cadastrado no sistema."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void processarOSComTecnicoInativo() {
		try {
			os.setTecnico(tecnicoInativo);
			List<String> erros = ordemServicoAplicacao.processarOS(os);

			Assert.assertTrue(erros.contains("Técnico inválido."));
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
