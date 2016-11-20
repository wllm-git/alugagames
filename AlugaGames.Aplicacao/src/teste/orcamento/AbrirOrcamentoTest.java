package teste.orcamento;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.OrcamentoAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class AbrirOrcamentoTest {
	private static OrcamentoAplicacao orcamentoAplicacao;
	private static Cliente c1;

	@BeforeClass
	public static void inicializar() {
		c1 = new Cliente();

		ConnectionManager.beginTransaction();
		new ClienteRepositorio().adicionar(c1);
		ConnectionManager.commit();

		orcamentoAplicacao = new OrcamentoAplicacao();
	}
	
	@Test
	public void abrirOrcamentoComItens() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			o.setDescricao("Descrição dos problemas.");
			OrcamentoItem item = new OrcamentoItem();
			item.setNumeroSerie("2K1AS4L5");
			item.setDescricao("Controle");
			orcamentoAplicacao.adicionarItens(o, item);
			
			List<String> erros = orcamentoAplicacao.abrirOrcamento(o);
			
			if(!erros.isEmpty())
				Assert.fail();
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOrcamentoInexistente() {
		try {
			Orcamento o = new Orcamento();
			o.setCodigo(10);
			
			List<String> erros = orcamentoAplicacao.abrirOrcamento(o);
			Assert.assertTrue(erros.contains("O orçameto 10 não existe no sistema."));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOrcamentoSemItens() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			List<String> erros = orcamentoAplicacao.abrirOrcamento(o);
			
			Assert.assertTrue(erros.contains("Orçamento precisa ter itens."));
			Assert.assertEquals(StatusOrcamento.Iniciado, o.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOrcamentoSemDescricaoDoProblema() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			List<String> erros = orcamentoAplicacao.abrirOrcamento(o);
			
			Assert.assertTrue(erros.contains("Descrição não informada."));
			Assert.assertEquals(StatusOrcamento.Iniciado, o.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
