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
			return "Número de série " + obj.getNumeroSerie() + " já está em uso.";
		
		return null;
	}

}
