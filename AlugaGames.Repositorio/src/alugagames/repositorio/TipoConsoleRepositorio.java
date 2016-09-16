package alugagames.repositorio;

import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;

public class TipoConsoleRepositorio extends RepositorioBase<TipoConsole> implements ITipoConsoleRepositorio{

	public TipoConsoleRepositorio() {
		super(TipoConsole.class);
	}

}
