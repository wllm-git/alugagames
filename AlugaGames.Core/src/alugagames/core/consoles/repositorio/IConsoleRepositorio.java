package alugagames.core.consoles.repositorio;
import alugagames.core.consoles.Console;
import alugagames.core.shared.repositorio.IRepositorioBase;;

public interface IConsoleRepositorio extends IRepositorioBase<Console> {
	public void AtualizarStatusConsole(Console console);
}
