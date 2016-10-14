package alugagames.core.jogos.validacoes;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.regras.JogoPrecisaTerAnoLancamentoValido;
import alugagames.core.jogos.regras.JogoPrecisaTerCategoria;
import alugagames.core.jogos.regras.JogoPrecisaTerNomeUnicoAlt;
import alugagames.core.jogos.regras.JogoPrecisaTerNomeValido;
import alugagames.core.jogos.repositorio.IJogoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class JogoAptoParaAlteracao extends Validacao<Jogo> {
	
	public JogoAptoParaAlteracao(IJogoRepositorio repositorio){
		adicionarRegra(new JogoPrecisaTerNomeValido());
		adicionarRegra(new JogoPrecisaTerNomeUnicoAlt(repositorio));
		adicionarRegra(new JogoPrecisaTerCategoria());
		adicionarRegra(new JogoPrecisaTerAnoLancamentoValido());
	}
}
