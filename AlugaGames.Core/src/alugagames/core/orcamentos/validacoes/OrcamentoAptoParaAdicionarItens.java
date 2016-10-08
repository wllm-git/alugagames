package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaTerStatusValidoParaAddItem;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaAdicionarItens extends Validacao<Orcamento>{
	public OrcamentoAptoParaAdicionarItens(){
		adicionarRegra(new OrcamentoPrecisaTerStatusValidoParaAddItem());
	}
}
