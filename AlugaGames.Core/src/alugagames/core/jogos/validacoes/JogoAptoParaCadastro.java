package alugagames.core.jogos.validacoes;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.regras.JogoPrecisaTerAnoLancamentoValido;
import alugagames.core.jogos.regras.JogoPrecisaTerCategoria;
import alugagames.core.jogos.regras.JogoPrecisaTerNomeUnico;
import alugagames.core.jogos.regras.JogoPrecisaTerNomeValido;
import alugagames.core.jogos.repositorio.IJogoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class JogoAptoParaCadastro extends Validacao<Jogo> {
	
	public JogoAptoParaCadastro(IJogoRepositorio repositorio){
		adicionarRegra(new JogoPrecisaTerNomeValido());
		adicionarRegra(new JogoPrecisaTerNomeUnico(repositorio));
		adicionarRegra(new JogoPrecisaTerCategoria());
		adicionarRegra(new JogoPrecisaTerAnoLancamentoValido());
	}
}
