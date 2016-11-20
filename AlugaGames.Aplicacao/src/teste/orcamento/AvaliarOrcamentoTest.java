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

public class AvaliarOrcamentoTest {
	private static OrcamentoAplicacao orcamentoAplicacao;
	private static Orcamento orcamento;
	private static Cliente c1;
	private static Funcionario a1;
	private static Funcionario tecnicoAtivo;
	private static Funcionario tecnicoInativo;

	@BeforeClass
	public static void inicializar() {
		c1 = new Cliente();
		
		a1 = new Funcionario();
		a1.setFuncao(Funcao.Atendente);
		a1.setAtivo(true);
		
		tecnicoAtivo= new Funcionario();
		tecnicoAtivo.setFuncao(Funcao.Tecnico);
		tecnicoAtivo.setAtivo(true);
		
		tecnicoInativo= new Funcionario();
		tecnicoInativo.setFuncao(Funcao.Tecnico);
		tecnicoInativo.setAtivo(false);
		
		ConnectionManager.beginTransaction();
		new ClienteRepositorio().adicionar(c1);
		new FuncionarioRepositorio().adicionar(a1);
		new FuncionarioRepositorio().adicionar(tecnicoAtivo);
		new FuncionarioRepositorio().adicionar(tecnicoInativo);
		ConnectionManager.commit();
		
		orcamentoAplicacao = new OrcamentoAplicacao();
		orcamento = orcamentoAplicacao.iniciarOrcamento(c1);
		orcamento.setDescricao("Descrição dos problemas.");
		OrcamentoItem item = new OrcamentoItem();
		item.setNumeroSerie("2K1AS4L5");
		item.setDescricao("Controle");
		orcamentoAplicacao.adicionarItens(orcamento, item);
		orcamentoAplicacao.abrirOrcamento(orcamento);
		orcamento.setAtendente(a1);
		orcamentoAplicacao.receberOrcamento(orcamento);
	}
	
	@Before
	public void removerTecnico(){
		orcamento.setTecnico(null);
	}
	
	@Test
	public void avaliarOrcamentoOK() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			o.setDescricao("Descrição dos problemas.");
			OrcamentoItem item = new OrcamentoItem();
			item.setNumeroSerie("2K1AS4L5");
			item.setDescricao("Controle");
			orcamentoAplicacao.adicionarItens(o, item);
			orcamentoAplicacao.abrirOrcamento(o);
			o.setAtendente(a1);
			orcamentoAplicacao.receberOrcamento(o);
			
			o.setTecnico(tecnicoAtivo);
			
			List<String> erros = orcamentoAplicacao.avaliarOrcamento(o);
			
			if(!erros.isEmpty())
				Assert.fail();
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void avaliarOrcamentoInexistente() {
		try {
			Orcamento o = new Orcamento();
			o.setCodigo(10);
			
			List<String> erros = orcamentoAplicacao.avaliarOrcamento(o);
			Assert.assertTrue(erros.contains("O orçameto 10 não existe no sistema."));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void avaliarOrcamentoAindaNãoRecebido() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			
			List<String> erros = orcamentoAplicacao.avaliarOrcamento(o);
			Assert.assertTrue(erros.contains("Orçamento "+ o.getCodigo() +" não foi recebido."));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void avaliarOrcamentoSemTecnico() {
		try {
			List<String> erros = orcamentoAplicacao.avaliarOrcamento(orcamento);
			
			Assert.assertTrue(erros.contains("Técnico não informado."));
			Assert.assertEquals(StatusOrcamento.Recebido, orcamento.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void avaliarOrcamentoComTecnicoNaoCadastrado() {
		try {
			orcamento.setTecnico(new Funcionario());
			List<String> erros = orcamentoAplicacao.avaliarOrcamento(orcamento);
			
			Assert.assertTrue(erros.contains("Técnico informado não cadastrado no sistema."));
			Assert.assertEquals(StatusOrcamento.Recebido, orcamento.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void avaliarOrcamentoComTecnicoInativo() {
		try {
			orcamento.setTecnico(tecnicoInativo);
			List<String> erros = orcamentoAplicacao.avaliarOrcamento(orcamento);
			
			Assert.assertTrue(erros.contains("Técnico inválido."));
			Assert.assertEquals(StatusOrcamento.Recebido, orcamento.getStatus());
			
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
		
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
