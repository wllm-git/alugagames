package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.StatusAluguel;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelSituacaoDeFinalizarValida implements IRegra<Aluguel>{
	private IAluguelRepositorio _repositorio;
	
	public AluguelSituacaoDeFinalizarValida(IAluguelRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public String validar(Aluguel obj){
		Aluguel a = _repositorio.buscarPorID(obj.getId());
		if(a == null)
			return "n�o foi poss�vel verificar a situa��o do aluguel " + obj.getCodigo() + ".";
		else if(!a.isAluguel())
			return null;
		else if(!a.getStatus().equals(StatusAluguel.Confirmado))
			return "aluguel " + a.getCodigo() + " n�o pode ser finalizado.";
				
		return null;
	}
}
