package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaTerStatusValidoParaAddItem implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		if (obj.getStatus() != StatusOrcamento.Iniciado && obj.getStatus() != StatusOrcamento.Aberto)
			return "Or�amento " + obj.getCodigo() + " n�o pode receber novo item.";
		return null;
	}

}
