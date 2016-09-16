package alugagames.repositorio;

import alugagames.core.midias.Midia;
import alugagames.core.midias.repositorio.IMidiaRepositorio;

public class MidiaRepositorio extends RepositorioBase<Midia> implements IMidiaRepositorio{

	public MidiaRepositorio() {
		super(Midia.class);
	}
	
}
