package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstaEmAvaliacao;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerConfirmado extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaSerConfirmado(){
		adicionarRegra(new OrcamentoPrecisaEstaEmAvaliacao());
	}
}
