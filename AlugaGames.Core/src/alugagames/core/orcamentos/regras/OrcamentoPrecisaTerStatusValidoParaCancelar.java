package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaTerStatusValidoParaCancelar implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		if (obj.getStatus() == StatusOrcamento.Aceito)
			return "Or�amento " + obj.getCodigo() + " j� foi aceito e n�o pode ser cancelado.";
		else if (obj.getStatus() == StatusOrcamento.Cancelado)
			return "Or�amento " + obj.getCodigo() + " j� est� cancelado.";

		return null;
	}

}
