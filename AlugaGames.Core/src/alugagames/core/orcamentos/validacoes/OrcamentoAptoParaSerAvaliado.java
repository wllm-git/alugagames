package alugagames.core.orcamentos.validacoes;

import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstaRecebido;
import alugagames.core.orcamentos.regras.OrcamentoPrecisarTerTecnicoValido;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerAvaliado extends Validacao<Orcamento>{

	public OrcamentoAptoParaSerAvaliado(FuncionarioServico _funcionarioServico) {
		adicionarRegra(new OrcamentoPrecisaEstaRecebido());
		adicionarRegra(new OrcamentoPrecisarTerTecnicoValido(_funcionarioServico));
	}
	
}
