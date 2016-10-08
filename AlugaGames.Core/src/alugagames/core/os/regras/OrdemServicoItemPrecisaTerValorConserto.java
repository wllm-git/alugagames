package alugagames.core.os.regras;

import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.StatusOSItem;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoItemPrecisaTerValorConserto implements IRegra<OrdemServicoItem> {

	@Override
	public String validar(OrdemServicoItem obj) {
		if(obj.getStatusOSItem() != StatusOSItem.OK && obj.getStatusOSItem() != StatusOSItem.SemConserto)
			return "Status do item "+ obj.getDescricao() +" serie: "+ obj.getNumeroSerie() +" inválido.";
		
		if(obj.getStatusOSItem() == StatusOSItem.OK) {
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
