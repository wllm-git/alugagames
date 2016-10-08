package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaTerStatusValidoParaCancelar implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		if (obj.getStatus() == StatusOrcamento.Aceito)
			return "Orçamento " + obj.getCodigo() + " já foi aceito e não pode ser cancelado.";
		else if (obj.getStatus() == StatusOrcamento.Cancelado)
			return "Orçamento " + obj.getCodigo() + " já está cancelado.";

		return null;
	}

}
