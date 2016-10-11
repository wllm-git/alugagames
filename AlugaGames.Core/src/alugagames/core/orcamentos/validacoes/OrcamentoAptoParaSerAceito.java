package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstarConfirmado;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerAceito extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaSerAceito(){
		adicionarRegra(new OrcamentoPrecisaEstarConfirmado());
	}
}
