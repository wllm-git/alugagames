package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.orcamentos.regras.OrcamentoItemPrecisaTerDescricaoValida;
import alugagames.core.orcamentos.regras.OrcamentoItemPrecisaTerNumeroSerie;
import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class OrcamentoItemApto extends Validacao<OrcamentoItem>{
	
	public OrcamentoItemApto(TipoConsoleServico tipoConsoleServico){
		adicionarRegra(new OrcamentoItemPrecisaTerNumeroSerie());
		adicionarRegra(new OrcamentoItemPrecisaTerDescricaoValida(tipoConsoleServico));
	}
}
