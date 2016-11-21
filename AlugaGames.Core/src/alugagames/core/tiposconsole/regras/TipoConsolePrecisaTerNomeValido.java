package alugagames.core.tiposconsole.regras;

import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;

public class TipoConsolePrecisaTerNomeValido implements IRegra<TipoConsole> {

	@Override
	public String validar(TipoConsole obj) {
		if(obj.getNome() == null || obj.getNome().isEmpty())
			return "Nome não informado.";
		if(obj.getNome().length() <= 3)
			return "Nome deve ter ao menos 4 caracteres.";
		return null;
	}

}
