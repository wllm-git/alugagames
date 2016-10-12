package alugagames.core.jogos.regras;

import alugagames.core.jogos.Jogo;
import alugagames.core.shared.validacoesregras.IRegra;

public class JogoPrecisaTerAnoLancamentoValido implements IRegra<Jogo> {

	@Override
	public String validar(Jogo obj) {
		if(obj.getAnoLancamento() == null)
			return "Ano de lançamento não informado.";
		
		return null;
	}

}
