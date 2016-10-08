package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoItemPrecisaTerValorConserto implements IRegra<OrcamentoItem> {

	@Override
	public String validar(OrcamentoItem obj) {
		if(obj.isTemConserto()) {
			if(obj.getValor() <= 0)
				return "O "+ obj.getDescricao() +" serie: "+ obj.getNumeroSerie() +" não possui valor.";
		}
		else {
			if(obj.getValor() != 0)
				return "O "+ obj.getDescricao() +" serie: "+ obj.getNumeroSerie() +" deve ter o valor zerado.";
		}
		
		return null;
	}

}
