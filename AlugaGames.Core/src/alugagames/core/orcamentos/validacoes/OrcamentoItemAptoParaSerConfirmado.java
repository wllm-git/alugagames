package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.orcamentos.regras.OrcamentoItemPrecisaTerValorConserto;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoItemAptoParaSerConfirmado extends Validacao<OrcamentoItem>{
	
	public OrcamentoItemAptoParaSerConfirmado(){
		adicionarRegra(new OrcamentoItemPrecisaTerValorConserto());
	}
}
