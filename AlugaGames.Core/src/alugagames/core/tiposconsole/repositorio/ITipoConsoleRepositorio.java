package alugagames.core.tiposconsole.repositorio;
import alugagames.core.shared.repositorio.IRepositorioBase;
import alugagames.core.tiposconsole.TipoConsole;;

public interface ITipoConsoleRepositorio extends IRepositorioBase<TipoConsole> {

	public TipoConsole buscarPorNome(String nome);
	
}
