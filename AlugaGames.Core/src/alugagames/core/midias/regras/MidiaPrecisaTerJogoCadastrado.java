package alugagames.core.midias.regras;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.JogoServico;
import alugagames.core.midias.Midia;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaTerJogoCadastrado implements IRegra<Midia> {

	private JogoServico _jogoServico;
	
	public MidiaPrecisaTerJogoCadastrado(JogoServico jogoServico) {
		_jogoServico = jogoServico;
	}

	@Override
	public String validar(Midia obj) {
		if(obj.getJogo() == null)
			return "Jogo não informado.";
		
		Jogo j = _jogoServico.buscarPorID(obj.getJogo().getId());
		
		if(j == null)
			return "Jogo "+ obj.getJogo().getNome() +" não existe no sistema.";
		
		return null;
	}

}
