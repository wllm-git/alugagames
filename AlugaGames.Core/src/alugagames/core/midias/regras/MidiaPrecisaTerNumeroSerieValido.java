package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaTerNumeroSerieValido implements IRegra<Midia> {

	@Override
	public String validar(Midia obj) {
		if(obj.getNumeroSerie() == null)
			return "N�mero de s�rie n�o informado.";
		
		return null;
	}

}
