package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class ConsolePrecisaEstarAtivo implements IRegra<Console>{

	private IConsoleRepositorio _repositorio;
	
	public ConsolePrecisaEstarAtivo(IConsoleRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Console obj) {
		Console c = _repositorio.buscarPorID(obj.getId());
		if(c == null)
			return "não foi possível verificar se o console "+ obj.getNumeroSerie() +" está ativo.";
		else if(!c.isAtivo())
			return "console "+ c.getNumeroSerie() +" não está ativo.";
		
		return null;
	}
}
