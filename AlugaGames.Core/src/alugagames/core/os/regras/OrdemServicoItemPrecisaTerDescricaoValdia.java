package alugagames.core.os.regras;

import alugagames.core.os.OrdemServicoItem;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoItemPrecisaTerDescricaoValdia implements IRegra<OrdemServicoItem> {

	@Override
	public String validar(OrdemServicoItem obj) {
		if(obj.getDescricao() == null || obj.getDescricao().isEmpty())
			return "Descri��o do item "+ obj.getNumeroSerie() +" n�o informada.";
		return null;
	}

}
