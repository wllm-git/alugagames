package alugagames.core.os.validacoes;

import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.regras.OrdemServicoItemPrecisaTerValorConserto;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoItemAptoParafinalizarServico extends Validacao<OrdemServicoItem> {
	public OrdemServicoItemAptoParafinalizarServico(){
		adicionarRegra(new OrdemServicoItemPrecisaTerValorConserto());
	}
}
