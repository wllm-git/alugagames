package alugagames.core.midias.validacoes;

import alugagames.core.midias.Midia;
import alugagames.core.midias.regras.MidiaNaoPodeEstarAlugada;
import alugagames.core.midias.regras.MidiaPrecisaEstarAtiva;
import alugagames.core.midias.regras.MidiaPrecisaExistirNoSistema;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class MidiaAptaParaSerInativada extends Validacao<Midia>{
	public MidiaAptaParaSerInativada(IMidiaRepositorio repositorio){
		adicionarRegra(new MidiaPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new MidiaNaoPodeEstarAlugada());
		adicionarRegra(new MidiaPrecisaEstarAtiva());
	}
}
