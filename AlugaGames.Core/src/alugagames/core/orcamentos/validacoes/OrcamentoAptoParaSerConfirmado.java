package alugagames.core.orcamentos.validacoes;

import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstarEmAvaliacao;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaExistirNoSistema;
import alugagames.core.orcamentos.regras.OrcamentoPrecisarTerTecnicoValido;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerConfirmado extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaSerConfirmado(IOrcamentoRepositorio repositorio, FuncionarioServico funcionarioServico) {
		adicionarRegra(new OrcamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrcamentoPrecisaEstarEmAvaliacao());
		adicionarRegra(new OrcamentoPrecisarTerTecnicoValido(funcionarioServico));
	}
}
