package alugagames.core.orcamentos.validacoes;

import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstarRecebido;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaExistirNoSistema;
import alugagames.core.orcamentos.regras.OrcamentoPrecisarTerTecnicoValido;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerAvaliado extends Validacao<Orcamento>{

	public OrcamentoAptoParaSerAvaliado(IOrcamentoRepositorio repositorio, FuncionarioServico _funcionarioServico) {
		adicionarRegra(new OrcamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrcamentoPrecisaEstarRecebido());
		adicionarRegra(new OrcamentoPrecisarTerTecnicoValido(_funcionarioServico));
	}
	
}
