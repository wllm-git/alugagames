package alugagames.core.tiposconsole.regras;

import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;

public class TipoConsolePrecisaTerNomeValido implements IRegra<TipoConsole> {

	@Override
	public String validar(TipoConsole obj) {
		
		if(obj.getNome() == null)
			return "O nome precisa ser preenchido";
		return null;
	}

}
