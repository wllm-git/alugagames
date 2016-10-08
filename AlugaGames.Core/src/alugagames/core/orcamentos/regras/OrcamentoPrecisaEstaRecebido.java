package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaEstaRecebido implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		if(obj.getStatus() != StatusOrcamento.Recebido)
			return "Orçamento "+ obj.getCodigo() +" não foi recebido.";
		return null;
	}

}
