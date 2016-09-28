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
			return "não foi possível verificar a situação do alguel " + obj.getCodigo() + ".";
		else if(!a.isAluguel())
			return null;
		else if(a.getStatus().equals(StatusAluguel.Cancelado))
			return "aluguel " + a.getCodigo() + " já está cancelado.";
		else if(a.getStatus().equals(StatusAluguel.Fechado))
			return "aluguel " + a.getCodigo() + " está Fechado e não pode ser mais cancelado.";
		
		return null;
	}

}
