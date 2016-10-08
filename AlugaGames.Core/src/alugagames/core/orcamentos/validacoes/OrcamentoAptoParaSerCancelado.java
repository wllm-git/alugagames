package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaTerStatusValidoParaCancelar;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerCancelado extends Validacao<Orcamento>{
	public OrcamentoAptoParaSerCancelado(){
		adicionarRegra(new OrcamentoPrecisaTerStatusValidoParaCancelar());
	}
}
