package alugagames.core.os.regras;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.StatusOS;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaEstaAguardando implements IRegra<OrdemServico> {

	@Override
	public String validar(OrdemServico obj) {
		if(obj.getStatus() != StatusOS.Aguardando)
			return "Ordem de serviço "+ obj.getCodigo() +" não está aguardando fechamento.";
		
		return null;
	}

}
