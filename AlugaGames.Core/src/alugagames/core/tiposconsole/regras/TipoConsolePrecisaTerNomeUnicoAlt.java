package alugagames.core.tiposconsole.regras;

import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;

public class TipoConsolePrecisaTerNomeUnicoAlt implements IRegra<TipoConsole> {
	
	private ITipoConsoleRepositorio _repositorio;
	
	public TipoConsolePrecisaTerNomeUnicoAlt(ITipoConsoleRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(TipoConsole obj) {
		TipoConsole tc = _repositorio.buscarPorNome(obj.getNome());
		
		if(tc != null && !tc.getId().equals(obj.getId()))
			return "Nome já está em uso.";
		
		return null;
	}
}
