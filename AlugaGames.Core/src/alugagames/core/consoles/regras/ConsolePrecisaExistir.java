package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class ConsolePrecisaExistir implements IRegra<Console>{
	private IConsoleRepositorio _repositorio;
	
	public ConsolePrecisaExistir(IConsoleRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Console obj) {
		Console c = _repositorio.buscarPorID(obj.getId());
		if(c == null)
			return "console "+ obj.getNumeroSerie() +" não está cadastrado no sistema.";
		
		return null;
	}
}
