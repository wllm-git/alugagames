package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaEstaAberto implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		if(obj.getStatus() != StatusOrcamento.Aberto)
			return "Orcamento " + obj.getCodigo() + " não está  aberto.";
		
		return null;
	}

}
