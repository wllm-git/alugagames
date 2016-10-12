package alugagames.core.tiposconsole.repositorio;
import alugagames.core.shared.repositorio.IRepositorioBase;
import alugagames.core.tiposconsole.TipoConsole;;

public interface ITipoConsoleRepositorio extends IRepositorioBase<TipoConsole> {

	TipoConsole buscarPorNome(String nome);
	
}
