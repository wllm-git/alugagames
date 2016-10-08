package alugagames.core.os.validacoes;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.regras.OrdemServicoPrecisaEstaEmProcessamento;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoAptaParaFinalizarServico extends Validacao<OrdemServico>{
	public OrdemServicoAptaParaFinalizarServico(){
		adicionarRegra(new OrdemServicoPrecisaEstaEmProcessamento());
	}
}
