package alugagames.core.jogos.regras;

import alugagames.core.jogos.Jogo;
import alugagames.core.shared.validacoesregras.IRegra;

public class JogoPrecisaTerNomeValido implements IRegra<Jogo> {

	@Override
	public String validar(Jogo obj) {
		if(obj.getNome() == null || obj.getNome().isEmpty())
			return "Nome não informado.";
		else if(obj.getNome().length() <= 5 )
			return "Nome deve ter ao menos 6 caracteres.";
		
		return null;
	}

}
