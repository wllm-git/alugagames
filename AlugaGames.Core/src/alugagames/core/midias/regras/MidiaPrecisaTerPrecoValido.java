package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaTerPrecoValido implements IRegra<Midia> {

	@Override
	public String validar(Midia obj) {
		if(obj.getPreco() <= 0)
			return "Preço inválido.";
		return null;
	}

}
