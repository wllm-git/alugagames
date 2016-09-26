package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.shared.validacoesregras.IRegra;

public class ReservaPrecisaTerItensDisponiveis implements IRegra<Aluguel> {

	@Override
	public String validar(Aluguel obj) {
		if(obj.getConsoles().isEmpty() && obj.getMidias().isEmpty() && obj.getAcessorios().isEmpty())
			return "Reserva n�o possui itens selecionados.";
		return null;
	}
}
