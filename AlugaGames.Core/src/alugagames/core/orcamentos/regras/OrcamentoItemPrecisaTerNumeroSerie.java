package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoItemPrecisaTerNumeroSerie implements
		IRegra<OrcamentoItem> {

	@Override
	public String validar(OrcamentoItem obj) {
		if(obj.getNumeroSerie() == null || obj.getNumeroSerie().isEmpty())
			return "Número de serie não informado.";
		else if(obj.getNumeroSerie().length() <= 3)
			return "Número de serie deve ter ao menos 4 caracteres.";
		else if(obj.getNumeroSerie().length() > 20)
			return "Número de serie deve ter no máximo 20 caracteres.";
		
		return null;
	}

}
