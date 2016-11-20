package alugagames.core.orcamentos.validacoes;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaEstarConfirmado;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaExistirNoSistema;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaSerAceito extends Validacao<Orcamento>{
	
	public OrcamentoAptoParaSerAceito(IOrcamentoRepositorio repositorio) {
		adicionarRegra(new OrcamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new OrcamentoPrecisaEstarConfirmado());
	}
}
