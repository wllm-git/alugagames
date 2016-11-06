package teste.aluguel;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;
import alugagames.core.clientes.Cliente;
import alugagames.repositorio.AluguelRepositorio;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class AbrirReservaTest {
	private static AluguelAplicacao aluguelAplicacao;
	private static Cliente c1;

	@BeforeClass
	public static void inicializar() {
		c1 = new Cliente();

		ConnectionManager.beginTransaction();
		new ClienteRepositorio().adicionar(c1);
		ConnectionManager.commit();

		aluguelAplicacao = new AluguelAplicacao();
	}
	
	@Test
	public void abrirReservaComCliente() {
		try {
			Aluguel a = aluguelAplicacao.abrirReserva(c1);

			Aluguel a2 = new AluguelRepositorio().buscarPorID(a.getId());

			Assert.assertEquals(a.getId(), a2.getId());

		} catch (Exception e) {
			Assert.fail();
		}

	}
	
	@Test
	public void abrirReservaSemCliente() {
		try {
			aluguelAplicacao.abrirReserva(null);
			
			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}

	}
	
	@Test
	public void abrirReservaClienteNaoCadastrado() {
		try {
			Cliente c = new Cliente();
			aluguelAplicacao.abrirReserva(c);

			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}

	}
}
