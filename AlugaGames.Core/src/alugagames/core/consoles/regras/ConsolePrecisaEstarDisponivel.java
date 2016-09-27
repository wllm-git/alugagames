package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.validacoesregras.IRegra;

public class ConsolePrecisaEstarDisponivel implements IRegra<Console>{

	private IConsoleRepositorio _repositorio;
	
	public ConsolePrecisaEstarDisponivel(IConsoleRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Console obj) {
		Console c = _repositorio.buscarPorID(obj.getId());
		if(c == null)
			return "console "+ obj.getNumeroSerie() +" não está cadastrado no sistema.";
		else if(!c.getStatus().equals(StatusProduto.Disponivel))
			return "console "+ c.getNumeroSerie() +" não está disponível.";
		
		return null;
	}

}
