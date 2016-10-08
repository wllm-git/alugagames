package alugagames.core.os.validacoes;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.regras.OrdemServicoPrecisaTerTecnicoValido;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoAptaParaProcessamento extends Validacao<OrdemServico> {
	public OrdemServicoAptaParaProcessamento(){
		adicionarRegra(new OrdemServicoPrecisaTerTecnicoValido());
	}
}
