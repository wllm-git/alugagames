package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoPrecisaEstarInativo implements IRegra<Equipamento>{

	@Override
	public String validar(Equipamento obj) {
		if(obj.isAtivo())
			return "Equipamento "+ obj.getNumeroSerie() +" está ativo.";
		
		return null;
	}

}
