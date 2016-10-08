package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaTerStatusValidoParaRemoverItem;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaRemoverItens extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaRemoverItens(){
		adicionarRegra(new OrcamentoPrecisaTerStatusValidoParaRemoverItem());
	}
}
