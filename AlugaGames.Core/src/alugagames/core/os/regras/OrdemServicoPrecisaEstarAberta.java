package alugagames.core.os.regras;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.StatusOS;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaEstarAberta implements IRegra<OrdemServico> {

	@Override
	public String validar(OrdemServico obj) {
		if(obj.getStatus() != StatusOS.Aberta)
			return "Ordem de servi�o " + obj.getCodigo() + " n�o est� aberta.";
		
		return null;
	}

}
