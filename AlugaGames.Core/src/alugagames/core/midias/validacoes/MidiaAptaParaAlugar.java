package alugagames.core.midias.validacoes;

import alugagames.core.midias.Midia;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class MidiaAptaParaAlugar extends Validacao<Midia>{
	public MidiaAptaParaAlugar(IMidiaRepositorio repositorio){
		//TODO adicionarRegra(new MidiaPrecisaExistir(repositorio));
		//TODO adicionarRegra(new MidiaPrecisaEstarAtiva(repositorio));
	}
}
