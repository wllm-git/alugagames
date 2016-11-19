package alugagames.core.jogos.repositorio;

import alugagames.core.jogos.Jogo;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IJogoRepositorio extends IRepositorioBase<Jogo> {

	public Jogo buscarPorNome(String nome);
	
}
