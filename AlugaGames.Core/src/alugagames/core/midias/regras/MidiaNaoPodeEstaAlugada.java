package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaNaoPodeEstaAlugada implements IRegra<Midia> {

	@Override
	public String validar(Midia obj) {
		if(obj.getStatus() == StatusProduto.Alugado)
			return "Midia " + obj.getNumeroSerie() + " está alugada.";
		
		return null;
	}

}
