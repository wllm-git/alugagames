package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstarEmAvaliacao;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaExistirNoSistema;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerConfirmado extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaSerConfirmado(IOrcamentoRepositorio repositorio) {
		adicionarRegra(new OrcamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrcamentoPrecisaEstarEmAvaliacao());
	}
}
