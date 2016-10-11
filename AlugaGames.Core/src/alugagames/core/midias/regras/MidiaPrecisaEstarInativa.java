package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaEstarInativa implements IRegra<Midia> {

	@Override
	public String validar(Midia obj) {
		if(obj.isAtivo())
			return "Midia " + obj.getNumeroSerie() + " já está ativa.";
		
		return null;
	}

}
