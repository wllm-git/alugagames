import java.util.Date;

import alugagames.core.atendentes.Atendente;
import alugagames.core.clientes.Cliente;
import alugagames.core.consoles.Console;
import alugagames.core.jogos.Jogo;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.ConsoleRepositorio;
import alugagames.repositorio.JogoRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class Teste {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente();
		Atendente a1 = new Atendente();
		
		TipoConsole tc1 = new TipoConsole();
		tc1.setNome("ps4");
		
		Jogo j1 = new Jogo();
		j1.setAnoLancamento(new Date());
		j1.setNome("TM4");
		j1.setPreco(15.0f);
		
		Jogo j2 = new Jogo();
		j2.setAnoLancamento(new Date());
		j2.setNome("TH2");
		j2.setPreco(10.0f);
		
		Console con1 = new Console();
		con1.setAno(new Date());
		con1.setAtivo(true);
		con1.setNumeroSerie("321321456");
		con1.setPreco(25.0f);
		con1.setTipoConsole(tc1);
		con1.setVoltagem(110);
		con1.getJogos().add(j1);
		con1.getJogos().add(j2);
		
		
		ConnectionManager.beginTransaction();
		
		//EntityManager em = ConnectionManager.getEntityManager();
		
		new TipoConsoleRepositorio().adicionar(tc1);
		new JogoRepositorio().adicionar(j1);
		new JogoRepositorio().adicionar(j2);
		new ConsoleRepositorio().adicionar(con1);
				
		//em.persist(tc1);
		//em.persist(j1);
		//em.persist(j2);
		//em.persist(con1);
		
		ConnectionManager.commit();
		ConnectionManager.dispose();
		
		//List<Jogo> jogos = new JogoRepositorio().buscarTodos();
		
		//if(jogos.isEmpty())
		//	return;
	}

}
