package alugagames.core.jogos.regras;

import alugagames.core.jogos.Jogo;
import alugagames.core.shared.validacoesregras.IRegra;

public class JogoPrecisaTerCategoria implements IRegra<Jogo> {

	@Override
	public String validar(Jogo obj) {
		if(obj.getCategoria() != null)
			return "Categoria não foi informada.";
		
		return null;
	}

}
