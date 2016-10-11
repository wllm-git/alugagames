package alugagames.core.midias.validacoes;

import alugagames.core.jogos.JogoServico;
import alugagames.core.midias.Midia;
import alugagames.core.midias.regras.MidiaPrecisaEstarAtiva;
import alugagames.core.midias.regras.MidiaPrecisaExistirNoSistema;
import alugagames.core.midias.regras.MidiaPrecisaTerJogoCadastrado;
import alugagames.core.midias.regras.MidiaPrecisaTerNumeroSerieUnicoAlt;
import alugagames.core.midias.regras.MidiaPrecisaTerNumeroSerieValido;
import alugagames.core.midias.regras.MidiaPrecisaTerPrecoValido;
import alugagames.core.midias.regras.MidiaPrecisaTerTipoConsoleCadastrado;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class MidiaAptaParaAlteracao extends Validacao<Midia>{
	public MidiaAptaParaAlteracao(IMidiaRepositorio repositorio, JogoServico jogoServico,
			TipoConsoleServico tipoConsoleServico) {
		adicionarRegra(new MidiaPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new MidiaPrecisaTerNumeroSerieValido());
		adicionarRegra(new MidiaPrecisaTerNumeroSerieUnicoAlt(repositorio));
		adicionarRegra(new MidiaPrecisaTerPrecoValido());
		adicionarRegra(new MidiaPrecisaTerJogoCadastrado(jogoServico));
		adicionarRegra(new MidiaPrecisaTerTipoConsoleCadastrado(tipoConsoleServico));
		adicionarRegra(new MidiaPrecisaEstarAtiva());
	}
}
