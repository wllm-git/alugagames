package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class ConsolePrecisaTerNumeroSerieUnico implements IRegra<Console> {

	private IConsoleRepositorio _repositorio;
	
	public ConsolePrecisaTerNumeroSerieUnico(IConsoleRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Console obj) {
		Console m = _repositorio.buscarPorNumeroSerie(obj.getNumeroSerie());
		
		if(m != null)
			return "N�mero de s�rie " + obj.getNumeroSerie() + " j� est� em uso.";
		
		return null;
	}

}
