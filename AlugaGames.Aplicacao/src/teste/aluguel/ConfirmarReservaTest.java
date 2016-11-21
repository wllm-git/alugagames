package teste.aluguel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.StatusAluguel;
import alugagames.core.clientes.Cliente;
import alugagames.core.consoles.Console;
import alugagames.core.jogos.Jogo;
import alugagames.core.midias.Midia;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.Voltagem;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.ConsoleRepositorio;
import alugagames.repositorio.JogoRepositorio;
import alugagames.repositorio.MidiaRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class ConfirmarReservaTest {
	private static AluguelAplicacao aluguelAplicacao;
	private Aluguel reserva; 
	private static Cliente c1;
	private static TipoConsole tc1;
	private static Jogo j1;
	private static Jogo j2;
	private static Midia m1;
	private static Midia m2;
	private static Console con1;
	private static Date dtInicio;
	private static Date dtFim;

	@BeforeClass
	public static void inicializar() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, 1);
		dtInicio = c.getTime();
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date());
		c2.add(Calendar.MONTH, 2);
		dtFim = c2.getTime();
		
		c1 = new Cliente();
		
		tc1 = new TipoConsole();
		tc1.setNome("ps4");

		j1 = new Jogo();
		j1.setAnoLancamento("2016");
		j1.setNome("TM4");

		j2 = new Jogo();
		j2.setAnoLancamento("2016");
		j2.setNome("TH2");

		m1 = new Midia();
		m1.setAtivo(true);
		m1.setStatus(StatusProduto.Disponivel);
		m1.setNumeroSerie("54588");
		m1.setTipoConsole(tc1);
		m1.setJogo(j1);
		m1.setPreco(15.0f);

		m2 = new Midia();
		m2.setAtivo(true);
		m2.setStatus(StatusProduto.Disponivel);
		m2.setNumeroSerie("34377");
		m2.setTipoConsole(tc1);
		m2.setJogo(j2);
		m2.setPreco(10.0f);

		con1 = new Console();
		con1.setAno("2016");
		con1.setAtivo(true);
		con1.setNumeroSerie("321321456");
		con1.setPreco(25.0f);
		con1.setTipoConsole(tc1);
		con1.setVoltagem(Voltagem.V_110);
		con1.setStatus(StatusProduto.Disponivel);
		con1.getJogos().add(j1);
		con1.getJogos().add(j2);

		ConnectionManager.beginTransaction();
		new TipoConsoleRepositorio().adicionar(tc1);
		new JogoRepositorio().adicionar(j1);
		new JogoRepositorio().adicionar(j2);
		new ConsoleRepositorio().adicionar(con1);
		new ClienteRepositorio().adicionar(c1);
		new MidiaRepositorio().adicionar(m1);
		new MidiaRepositorio().adicionar(m2);
		ConnectionManager.commit();

		aluguelAplicacao = new AluguelAplicacao();
	}
	
	@Before
	public void liberarProdutos() {

		ConnectionManager.beginTransaction();

		con1.setStatus(StatusProduto.Disponivel);
		m1.setStatus(StatusProduto.Disponivel);
		m2.setStatus(StatusProduto.Disponivel);
		new ConsoleRepositorio().atualizarStatusConsole(con1);
		new MidiaRepositorio().atualizarStatusMidia(m1);
		new MidiaRepositorio().atualizarStatusMidia(m1);

		ConnectionManager.commit();
		
		reserva = aluguelAplicacao.abrirReserva(c1);
	}
	
	@Test
	public void confirmarReservaComProdutos() {
		
		reserva.setDataAluguelInicio(dtInicio);
		reserva.setDataAluguelFim(dtFim);
		reserva.getConsoles().add(con1);
		reserva.getMidias().add(m1);
		reserva.getMidias().add(m2);
		
		List<String> erros = aluguelAplicacao.confirmarReserva(reserva);

		if (!erros.isEmpty())
			Assert.fail();
		else {
			Aluguel a2 = aluguelAplicacao.buscarReservaPorCodigo(reserva.getCodigo());

			if (a2 == null)
				Assert.fail();
			else {
				Assert.assertEquals(reserva.getId(), a2.getId());
				Assert.assertEquals(StatusAluguel.Reservado, a2.getStatus());
			}
		}
	}
	
	@Test
	public void confirmarReservaSemProdutos() {
		
		reserva.setDataAluguelInicio(dtInicio);
		reserva.setDataAluguelFim(dtFim);
		List<String> erros = aluguelAplicacao.confirmarReserva(reserva);

		if (erros.isEmpty())
			Assert.fail();
		else {
			Aluguel a2 = aluguelAplicacao.buscarReservaPorCodigo(reserva.getCodigo());

			if (a2 == null)
				Assert.fail();
			else {
				Assert.assertEquals(reserva.getId(), a2.getId());
				Assert.assertEquals(StatusAluguel.Aberto, a2.getStatus());
			}
		}
	}
	
	@Test
	public void confirmarReservaComProdutoIndisponivel() {
		reservarProdutos();
		
		reserva.setDataAluguelInicio(dtInicio);
		reserva.setDataAluguelFim(dtFim);
		reserva.getConsoles().add(con1);
		reserva.getMidias().add(m1);
		reserva.getMidias().add(m2);
		
		List<String> erros = aluguelAplicacao.confirmarReserva(reserva);

		if (erros.isEmpty())
			Assert.fail();
		else {
			Aluguel a2 = aluguelAplicacao.buscarReservaPorCodigo(reserva.getCodigo());

			if (a2 == null)
				Assert.fail();
			else {
				Assert.assertEquals(reserva.getId(), a2.getId());
				Assert.assertEquals(StatusAluguel.Aberto, a2.getStatus());
			}
		}
	}
	
	private void reservarProdutos(){
		ConnectionManager.beginTransaction();
		con1.setStatus(StatusProduto.Reservado);
		m1.setStatus(StatusProduto.Reservado);
		m2.setStatus(StatusProduto.Reservado);
		new ConsoleRepositorio().atualizarStatusConsole(con1);
		new MidiaRepositorio().atualizarStatusMidia(m1);
		new MidiaRepositorio().atualizarStatusMidia(m1);
		ConnectionManager.commit();
		ConnectionManager.dispose();
	}

	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
