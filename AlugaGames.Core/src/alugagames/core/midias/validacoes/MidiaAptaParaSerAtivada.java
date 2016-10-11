package alugagames.core.midias.validacoes;

import alugagames.core.midias.Midia;
import alugagames.core.midias.regras.MidiaPrecisaEstarInativa;
import alugagames.core.midias.regras.MidiaPrecisaExistirNoSistema;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class MidiaAptaParaSerAtivada extends Validacao<Midia>{

	public MidiaAptaParaSerAtivada(IMidiaRepositorio repositorio) {
		adicionarRegra(new MidiaPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new MidiaPrecisaEstarInativa());
	}

}
