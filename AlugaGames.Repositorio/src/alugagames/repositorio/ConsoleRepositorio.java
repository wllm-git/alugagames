package alugagames.repositorio;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;

public class ConsoleRepositorio extends RepositorioBase<Console> implements IConsoleRepositorio {

	public ConsoleRepositorio() {
		super(Console.class);
	}
	
}
