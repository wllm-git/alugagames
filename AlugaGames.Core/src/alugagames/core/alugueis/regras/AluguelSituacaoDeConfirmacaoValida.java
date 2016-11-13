package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.StatusAluguel;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelSituacaoDeConfirmacaoValida implements IRegra<Aluguel> {

	@Override
	public String validar(Aluguel obj) {
		if(obj.getStatus() != StatusAluguel.Reservado)
			return "Aluguel "+ obj.getCodigo() +" não está no status Reservado e não pode ser confirmado.";
		return null;
	}

}
