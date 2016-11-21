package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaTerNumeroSerieValido implements IRegra<Midia> {

	@Override
	public String validar(Midia obj) {
		if(obj.getNumeroSerie() == null || obj.getNumeroSerie().isEmpty())
			return "N�mero de s�rie n�o informado.";
		else if(obj.getNumeroSerie().length() < 4)
			return "N�mero de s�rie deve ter ao menos 4 caracteres.";
		else if(!FuncoesGerais.apenasLetrasNumeros(obj.getNumeroSerie()))
			return "N�mero de s�rie deve conter apenas letras e/ou n�meros.";
		
		return null;
	}

}
