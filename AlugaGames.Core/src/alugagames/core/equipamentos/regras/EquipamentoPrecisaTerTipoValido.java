package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoPrecisaTerTipoValido implements IRegra<Equipamento> {

	@Override
	public String validar(Equipamento obj) {
		if(obj.getTipoEquipamento() == null)
			return "Tipo do equipamento não informado.";
		
		return null;
	}

}
