package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.AluguelPrecisaExistirNoSistema;
import alugagames.core.alugueis.regras.AluguelPrecisaTerAtendenteFechamentoValido;
import alugagames.core.alugueis.regras.AluguelSituacaoDeFinalizarValida;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.shared.validacoesregras.Validacao;

public class AluguelAptoParaSerFinalizado extends Validacao<Aluguel> {
	public AluguelAptoParaSerFinalizado(IAluguelRepositorio repositorio, FuncionarioServico atendenteServico) {
		adicionarRegra(new AluguelPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new AluguelSituacaoDeFinalizarValida(repositorio));
		adicionarRegra(new AluguelPrecisaTerAtendenteFechamentoValido(atendenteServico));
	}
}
