package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class ConsolePrecisaTerNumeroSerieValido implements IRegra<Console> {

	@Override
	public String validar(Console obj) {
		if(obj.getNumeroSerie() == null || obj.getNumeroSerie().isEmpty())
			return "Número de série não informado.";
		else if(obj.getNumeroSerie().length() < 4)
			return "Número de série deve ter ao menos 4 caracteres.";
		else if(!FuncoesGerais.apenasLetrasNumeros(obj.getNumeroSerie()))
			return "Número de série deve conter apenas letras e/ou números.";
		return null;
	}
}
