package teste.orcamento;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.OrcamentoAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class ReceberOrcamentoTest {
	private static OrcamentoAplicacao orcamentoAplicacao;
	private static Orcamento orcamento;
	private static Cliente c1;
	private static Funcionario atendenteAtivo;
	private static Funcionario atendenteInativo;

	@BeforeClass
	public static void inicializar() {
		c1 = new Cliente();
		
		atendenteAtivo= new Funcionario();
		atendenteAtivo.setFuncao(Funcao.Atendente);
		atendenteAtivo.setAtivo(true);
		
		atendenteInativo= new Funcionario();
		atendenteInativo.setFuncao(Funcao.Atendente);
		atendenteInativo.setAtivo(false);
		
		ConnectionManager.beginTransaction();
		new ClienteRepositorio().adicionar(c1);
		new FuncionarioRepositorio().adicionar(atendenteAtivo);
		new FuncionarioRepositorio().adicionar(atendenteInativo);
		ConnectionManager.commit();
		
		orcamentoAplicacao = new OrcamentoAplicacao();
		orcamento = orcamentoAplicacao.iniciarOrcamento(c1);
		orcamento.setDescricao("Descri��o dos problemas.");
		OrcamentoItem item = new OrcamentoItem();
		item.setNumeroSerie("2K1AS4L5");
		item.setDescricao("Controle");
		orcamentoAplicacao.adicionarItens(orcamento, item);
		orcamentoAplicacao.abrirOrcamento(orcamento);
		
	}
	
	@Before
	public void removerAtendente() {
		orcamento.setAtendente(null);
	}
	
	@Test
	public void receberOrcamentoOK() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			o.setDescricao("Descri��o dos problemas.");
			OrcamentoItem item = new OrcamentoItem();
			item.setNumeroSerie("2K1AS4L5");
			item.setDescricao("Controle");
			orcamentoAplicacao.adicionarItens(o, item);
			orcamentoAplicacao.abrirOrcamento(o);
			
			o.setAtendente(atendenteAtivo);
			
			List<String> erros = orcamentoAplicacao.receberOrcamento(o);
			
			if(!erros.isEmpty())
				Assert.fail();
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void receberOrcamentoInexistente() {
		try {
			Orcamento o = new Orcamento();
			o.setCodigo(10);
			
			List<String> erros = orcamentoAplicacao.receberOrcamento(o);
			Assert.assertTrue(erros.contains("O or�amento 10 n�o existe no sistema."));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void receberOrcamentoAindaN�oAberto() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			
			List<String> erros = orcamentoAplicacao.receberOrcamento(o);
			Assert.assertTrue(erros.contains("Or�amento " + o.getCodigo() + " n�o est�  aberto."));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void receberOrcamentoSemAtendente() {
		try {
			List<String> erros = orcamentoAplicacao.receberOrcamento(orcamento);
			
			Assert.assertTrue(erros.contains("Atendente n�o informado."));
			Assert.assertEquals(StatusOrcamento.Aberto, orcamento.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void receberOrcamentoComAtendenteNaoCadastrado() {
		try {
			orcamento.setAtendente(new Funcionario());
			List<String> erros = orcamentoAplicacao.receberOrcamento(orcamento);
			
			Assert.assertTrue(erros.contains("Atendente informado n�o cadastrado no sistema."));
			Assert.assertEquals(StatusOrcamento.Aberto, orcamento.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void receberOrcamentoComAtendenteInativo() {
		try {
			orcamento.setAtendente(atendenteInativo);
			List<String> erros = orcamentoAplicacao.receberOrcamento(orcamento);
			
			Assert.assertTrue(erros.contains("Atendente inv�lido."));
			Assert.assertEquals(StatusOrcamento.Aberto, orcamento.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
		
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
