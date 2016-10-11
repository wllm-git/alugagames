package alugagames.core.consoles.repositorio;
import alugagames.core.consoles.Console;
import alugagames.core.shared.repositorio.IRepositorioBase;;

public interface IConsoleRepositorio extends IRepositorioBase<Console> {
	public void atualizarStatusConsole(Console console);

	public Console buscarPorNumeroSerie(String numeroSerie);
}
