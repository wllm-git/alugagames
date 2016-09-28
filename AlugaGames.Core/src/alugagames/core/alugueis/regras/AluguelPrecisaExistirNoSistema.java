package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaExistirNoSistema implements IRegra<Aluguel>{
	private IAluguelRepositorio _repositorio;
	
	public AluguelPrecisaExistirNoSistema(IAluguelRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Aluguel obj) {
		Aluguel a = _repositorio.buscarPorID(obj.getId());
		if(a == null)
			return "aluguel " + obj.getCodigo() + " não está registrado no sistema.";
		
		return null;
	}
}
