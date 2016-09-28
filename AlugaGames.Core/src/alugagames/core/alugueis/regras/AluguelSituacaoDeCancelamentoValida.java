package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.StatusAluguel;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelSituacaoDeCancelamentoValida implements IRegra<Aluguel> {
	private IAluguelRepositorio _repositorio;
	
	public AluguelSituacaoDeCancelamentoValida(IAluguelRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Aluguel obj) {
		Aluguel a = _repositorio.buscarPorID(obj.getId());
		if(a == null)
			return "n�o foi poss�vel verificar a situa��o do alguel " + obj.getCodigo() + ".";
		else if(!a.isAluguel())
			return null;
		else if(a.getStatus().equals(StatusAluguel.Cancelado))
			return "aluguel " + a.getCodigo() + " j� est� cancelado.";
		else if(a.getStatus().equals(StatusAluguel.Fechado))
			return "aluguel " + a.getCodigo() + " est� Fechado e n�o pode ser mais cancelado.";
		
		return null;
	}

}
