package alugagames.core.tiposconsole.regras;

import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;

public class TipoConsolePrecisaTerNomeUnico implements IRegra<TipoConsole> {

	private ITipoConsoleRepositorio _repositorio;
	
	public TipoConsolePrecisaTerNomeUnico(ITipoConsoleRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(TipoConsole obj) {
		TipoConsole tc = _repositorio.buscarPorNome(obj.getNome());
		
		if(tc != null)
			return "Nome já está em uso.";
		
		return null;
	}

}
