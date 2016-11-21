package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaTerNumeroSerieValido implements IRegra<Midia> {

	@Override
	public String validar(Midia obj) {
		if(obj.getNumeroSerie() == null || obj.getNumeroSerie().isEmpty())
			return "Número de série não informado.";
		else if(obj.getNumeroSerie().length() < 4)
			return "Número de série deve ter ao menos 4 caracteres.";
		else if(!FuncoesGerais.apenasLetrasNumeros(obj.getNumeroSerie()))
			return "Número de série deve conter apenas letras e/ou números.";
		
		return null;
	}

}
