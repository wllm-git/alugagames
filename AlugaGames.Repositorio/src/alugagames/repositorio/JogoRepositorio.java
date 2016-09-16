package alugagames.repositorio;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.repositorio.IJogoRepositorio;

public class JogoRepositorio extends RepositorioBase<Jogo> implements IJogoRepositorio {

	public JogoRepositorio() {
		super(Jogo.class);
	}

}
