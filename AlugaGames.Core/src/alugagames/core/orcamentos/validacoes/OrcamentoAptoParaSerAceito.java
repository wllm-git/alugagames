package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstaConfirmado;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerAceito extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaSerAceito(){
		adicionarRegra(new OrcamentoPrecisaEstaConfirmado());
	}
}
