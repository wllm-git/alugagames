package alugagames.core.os.validacoes;

import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.regras.OrdemServicoPrecisaEstarAguardando;
import alugagames.core.os.regras.OrdemServicoPrecisaExistirNoSistema;
import alugagames.core.os.regras.OrdemServicoPrecisaTerAtendenteValido;
import alugagames.core.os.regras.OrdemServicoPrecisaTerTecnicoValido;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoAptaParaSerFechada extends Validacao<OrdemServico>{
	public OrdemServicoAptaParaSerFechada(IOrdemServicoRepositorio repositorio, FuncionarioServico funcionarioServico){
		adicionarRegra(new OrdemServicoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrdemServicoPrecisaEstarAguardando());
		adicionarRegra(new OrdemServicoPrecisaTerAtendenteValido(funcionarioServico));
		adicionarRegra(new OrdemServicoPrecisaTerTecnicoValido(funcionarioServico));
	}
}
