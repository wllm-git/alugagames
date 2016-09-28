package teste;
import java.util.Date;
import java.util.List;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;
import alugagames.core.clientes.Cliente;
import alugagames.core.consoles.Console;
import alugagames.core.jogos.Jogo;
import alugagames.core.midias.Midia;
import alugagames.core.shared.StatusProduto;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.ConsoleRepositorio;
import alugagames.repositorio.JogoRepositorio;
import alugagames.repositorio.MidiaRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class TesteReserva {

	public static void main(String[] args) {
		Cliente c1 = new Cliente();
		
		TipoConsole tc1 = new TipoConsole();
		tc1.setNome("ps4");
		
		Jogo j1 = new Jogo();
		j1.setAnoLancamento(new Date());
		j1.setNome("TM4");
				
		Jogo j2 = new Jogo();
		j2.setAnoLancamento(new Date());
		j2.setNome("TH2");
				
		Midia m1 = new Midia();
		m1.setAtivo(true);
		m1.setStatus(StatusProduto.Disponivel);
		m1.setNumeroSerie("54588");
		m1.setTipoConsole(tc1);
		m1.setJogo(j1);
		m1.setPreco(15.0f);
		
		Midia m2 = new Midia();
		m2.setAtivo(true);
		m2.setStatus(StatusProduto.Disponivel);
		m2.setNumeroSerie("34377");
		m2.setTipoConsole(tc1);
		m2.setJogo(j2);
		m2.setPreco(10.0f);
		
		Console con1 = new Console();
		con1.setAno(new Date());
		con1.setAtivo(true);
		con1.setNumeroSerie("321321456");
		con1.setPreco(25.0f);
		con1.setTipoConsole(tc1);
		con1.setVoltagem(110);
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
		ConnectionManager.dispose();
		
		try{
			
			Aluguel a = new AluguelAplicacao().abrirReserva(c1);
			a.getConsoles().add(con1);
			a.getMidias().add(m1);
			a.getMidias().add(m2);
			
			AluguelAplicacao ap = new AluguelAplicacao();
			
			List<String> erros = ap.confirmarReserva(a);
			
			for(String err : erros)
				System.out.println(err);
			
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
