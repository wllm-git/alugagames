package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.shared.validacoesregras.IRegra;

public class ConsolePrecisaTerPrecoMaiorQueZero implements IRegra<Console> {

	@Override
	public String validar(Console obj) {
		if(obj.getPreco() <= 0)
			return "Pre�o inv�lido.";
		
		return null;
	}

}
