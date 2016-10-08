package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.StatusAluguel;
import alugagames.core.shared.validacoesregras.IRegra;

public class ReservaPrecisaTerStatusValidoParaAddProdutos implements IRegra<Aluguel> {

	@Override
	public String validar(Aluguel obj) {
		if(obj.isAluguel())
			return "N�o � poss�vel adicionar novos produtos no aluguel " + obj.getCodigo() + ".";
		else if(obj.getStatus() == StatusAluguel.Cancelado)
			return "Reserva " + obj.getCodigo() + " est� concelada.";
		
		return null;
	}

}
