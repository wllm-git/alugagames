package alugagames.core.tiposconsole.regras;

import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;

public class TipoConsolePrecisaEstarAtivo implements IRegra<TipoConsole> {

	@Override
	public String validar(TipoConsole obj) {
		if(!obj.isAtivo())
			return "Tipo de console "+ obj.getNome() +" não está ativo.";
		
		return null;
	}

}
