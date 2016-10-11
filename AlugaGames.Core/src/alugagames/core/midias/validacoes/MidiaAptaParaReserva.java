package alugagames.core.midias.validacoes;

import alugagames.core.midias.Midia;
import alugagames.core.midias.regras.MidiaPrecisaEstaAtiva;
import alugagames.core.midias.regras.MidiaPrecisaExistirNoSistema;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class MidiaAptaParaReserva extends Validacao<Midia>{
	public MidiaAptaParaReserva(IMidiaRepositorio repositorio){
		adicionarRegra(new MidiaPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new MidiaPrecisaEstaAtiva());
	}
}
