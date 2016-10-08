package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaTerItens implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		if(obj.getOrcamentoItens().isEmpty())
			return "Orçamento precisa ter itens.";
		
		return null;
	}

}
