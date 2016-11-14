package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class ConsolePrecisaTerNumeroSerieValido implements IRegra<Console> {

	@Override
	public String validar(Console obj) {
		if(obj.getNumeroSerie() == null || obj.getNumeroSerie().isEmpty())
			return "N�mero de s�rie n�o informado.";
		else if(obj.getNumeroSerie().length() < 4)
			return "N�mero de s�rie deve ter ao menos 4 caracteres.";
		else if(!FuncoesGerais.apenasLetrasNumeros(obj.getNumeroSerie()))
			return "N�mero de s�rie deve conter apenas letras e/ou n�meros.";
		return null;
	}
}
