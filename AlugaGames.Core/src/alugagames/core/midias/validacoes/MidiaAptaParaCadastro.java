package alugagames.core.midias.validacoes;

import alugagames.core.jogos.JogoServico;
import alugagames.core.midias.Midia;
import alugagames.core.midias.regras.MidiaPrecisaTerJogoCadastrado;
import alugagames.core.midias.regras.MidiaPrecisaTerNumeroSerieUnico;
import alugagames.core.midias.regras.MidiaPrecisaTerNumeroSerieValido;
import alugagames.core.midias.regras.MidiaPrecisaTerTipoConsoleCadastrado;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class MidiaAptaParaCadastro extends Validacao<Midia>{
	public MidiaAptaParaCadastro(IMidiaRepositorio repositorio, JogoServico jogoServico, TipoConsoleServico tipoConsoleServico){
		adicionarRegra(new MidiaPrecisaTerNumeroSerieValido());
		adicionarRegra(new MidiaPrecisaTerNumeroSerieUnico(repositorio));
		adicionarRegra(new MidiaPrecisaTerJogoCadastrado(jogoServico));
		adicionarRegra(new MidiaPrecisaTerTipoConsoleCadastrado(tipoConsoleServico));
	}
}
