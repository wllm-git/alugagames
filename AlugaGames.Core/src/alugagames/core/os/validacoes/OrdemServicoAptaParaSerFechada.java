package alugagames.core.os.validacoes;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.regras.OrdemServicoPrecisaEstarAguardando;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoAptaParaSerFechada extends Validacao<OrdemServico>{
	public OrdemServicoAptaParaSerFechada(){
		adicionarRegra(new OrdemServicoPrecisaEstarAguardando());
	}
}
