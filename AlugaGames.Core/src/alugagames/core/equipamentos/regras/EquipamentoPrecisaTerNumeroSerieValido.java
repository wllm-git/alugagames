package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoPrecisaTerNumeroSerieValido implements IRegra<Equipamento> {

	@Override
	public String validar(Equipamento obj) {
		if(obj.getNumeroSerie() == null || obj.getNumeroSerie().isEmpty())
			return "N�mero de s�rie n�o informado.";
		else if(obj.getNumeroSerie().length() <= 3)
			return "N�mero de s�rie deve ter ao menos 4 caracteres.";
		
		return null;
	}

}
