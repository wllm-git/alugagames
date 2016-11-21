package alugagames.core.os.regras;

import alugagames.core.os.OrdemServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaTerItens implements IRegra<OrdemServico> {

	@Override
	public String validar(OrdemServico obj) {
		if(obj.getOrdemServicoItens() == null || obj.getOrdemServicoItens().isEmpty())
			return "Não foi informado itens.";
		
		return null;
	}

}
