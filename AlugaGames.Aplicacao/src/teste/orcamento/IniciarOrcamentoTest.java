package teste.orcamento;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.OrcamentoAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.core.orcamentos.Orcamento;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.OrcamentoRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class IniciarOrcamentoTest {
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
	public void iniciarOrcamentoComCliente() {
		try {
			Orcamento o = orcamentoAplicacao.iniciarOrcamento(c1);

			Orcamento o2 = new OrcamentoRepositorio().buscarPorID(o.getId());

			Assert.assertEquals(o.getId(), o2.getId());

		} catch (Exception e) {
			Assert.fail();
		}

	}
	
	@Test
	public void iniciarOrcamentoSemCliente() {
		try {
			orcamentoAplicacao.iniciarOrcamento(null);
			
			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}

	}
	
	@Test
	public void iniciarOrcamentoClienteNaoCadastrado() {
		try {
			Cliente c = new Cliente();
			orcamentoAplicacao.iniciarOrcamento(c);

			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}

	}
	
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
