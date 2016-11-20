package alugagames.core.orcamentos.validacoes;

import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstarAberto;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaExistirNoSistema;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstaNoPrazoDe48Horas;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaTerItens;
import alugagames.core.orcamentos.regras.OrcamentoPrecisarTerAtendenteValido;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerRecebido extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaSerRecebido(IOrcamentoRepositorio repositorio, FuncionarioServico funcionarioServico) {
		adicionarRegra(new OrcamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrcamentoPrecisaEstarAberto());
		adicionarRegra(new OrcamentoPrecisaEstaNoPrazoDe48Horas());
		adicionarRegra(new OrcamentoPrecisarTerAtendenteValido(funcionarioServico));
		adicionarRegra(new OrcamentoPrecisaTerItens());
	}
}
