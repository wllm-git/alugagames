package alugagames.core.os.regras;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.StatusOS;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaEstaEmProcessamento implements IRegra<OrdemServico> {

	@Override
	public String validar(OrdemServico obj) {
		if(obj.getStatus() != StatusOS.Processamento)
			return "Ordem de servi�o "+ obj.getCodigo() +" n�o est� em processamento.";
		
		return null;
	}

}
