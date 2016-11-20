package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaExistirNoSistema;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaTerDescricao;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaTerItens;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerAberto extends Validacao<Orcamento>{

	public OrcamentoAptoParaSerAberto(IOrcamentoRepositorio repositorio) {
		adicionarRegra(new OrcamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrcamentoPrecisaTerItens());
		adicionarRegra(new OrcamentoPrecisaTerDescricao());
	}

}
