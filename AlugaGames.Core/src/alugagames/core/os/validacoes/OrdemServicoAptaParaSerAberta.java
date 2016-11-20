package alugagames.core.os.validacoes;

import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.regras.OrdemServicoPrecisaTerAtendenteValido;
import alugagames.core.os.regras.OrdemServicoPrecisaTerItens;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoAptaParaSerAberta extends Validacao<OrdemServico>{
	public OrdemServicoAptaParaSerAberta(FuncionarioServico funcionarioServico){
		adicionarRegra(new OrdemServicoPrecisaTerAtendenteValido(funcionarioServico));
		adicionarRegra(new OrdemServicoPrecisaTerItens());
	}
}
