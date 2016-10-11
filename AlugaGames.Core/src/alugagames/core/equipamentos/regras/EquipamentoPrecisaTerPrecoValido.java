package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoPrecisaTerPrecoValido implements IRegra<Equipamento> {

	@Override
	public String validar(Equipamento obj) {
		if(obj.getPreco() <= 0)
			return "Pre�o inv�lido.";
		return null;
	}

}
