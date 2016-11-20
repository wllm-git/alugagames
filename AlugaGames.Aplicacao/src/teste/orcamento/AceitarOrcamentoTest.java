package teste.orcamento;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.OrcamentoAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.StatusOS;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.OrdemServicoRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class AceitarOrcamentoTest {
	private static OrcamentoAplicacao orcamentoAplicacao;
	private static Orcamento orcamento;
	private static Cliente c1;
	private static Funcionario a1;
	private static Funcionario t1;

	@BeforeClass
	public static void inicializar() {
		c1 = new Cliente();
		
		a1 = new Funcionario();
		a1.setFuncao(Funcao.Atendente);
		a1.setAtivo(true);
		
		t1= new Funcionario();
		t1.setFuncao(Funcao.Tecnico);
		t1.setAtivo(true);
				
		ConnectionManager.beginTransaction();
		new ClienteRepositorio().adicionar(c1);
		new FuncionarioRepositorio().adicionar(a1);
		new FuncionarioRepositorio().adicionar(t1);
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
		orcamento.setTecnico(t1);
		orcamentoAplicacao.avaliarOrcamento(orcamento);
	}
	
	@Test
	public void aceitarOrcamentoOK() {
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
			
			o.setTecnico(t1);
			orcamentoAplicacao.avaliarOrcamento(o);
			
			OrcamentoItem it2 = o.getOrcamentoItens().get(0); 
			it2.setTemConserto(true);
			it2.setValor(50);
			
			orcamentoAplicacao.confirmarOrcamento(o);
			
			List<String> erros = orcamentoAplicacao.aceitarOrcamento(o);
			
			if(!erros.isEmpty())
				Assert.fail();
			else{
				OrdemServico os = new OrdemServicoRepositorio().buscarPorOrcamento(o);
				
				if(os == null)
					Assert.fail();
				else{
					
					Assert.assertEquals(StatusOS.Aberta, os.getStatus());
					Assert.assertEquals(o.getId(), os.getOrcamento().getId());
				}
			}
		} catch (RuntimeException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void aceitarOrcamentoInexistente() {
		try {
			Orcamento o = new Orcamento();
			o.setCodigo(10);
			
			List<String> erros = orcamentoAplicacao.aceitarOrcamento(o);
			Assert.assertTrue(erros.contains("O orçamento 10 não existe no sistema."));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void aceitarOrcamentoAindaNãoConfirmada() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);
			
			List<String> erros = orcamentoAplicacao.aceitarOrcamento(o);
			Assert.assertTrue(erros.contains("Orçamento " + o.getCodigo() + " não está confirmado."));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
