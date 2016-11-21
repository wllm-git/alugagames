package alugagames.core.os.validacoes;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.regras.OrdemServicoPrecisaEstarEmProcessamento;
import alugagames.core.os.regras.OrdemServicoPrecisaExistirNoSistema;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoAptaParaFinalizarServico extends Validacao<OrdemServico>{
	public OrdemServicoAptaParaFinalizarServico(IOrdemServicoRepositorio repositorio){
		adicionarRegra(new OrdemServicoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrdemServicoPrecisaEstarEmProcessamento());
	}
}
