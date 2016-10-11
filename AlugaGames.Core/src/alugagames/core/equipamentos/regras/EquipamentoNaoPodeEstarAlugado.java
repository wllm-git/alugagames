package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoNaoPodeEstarAlugado implements IRegra<Equipamento> {

	@Override
	public String validar(Equipamento obj) {
		if(obj.getStatus() == StatusProduto.Alugado)
			return "Equipamento " + obj.getNumeroSerie() + " está alugado.";
		
		return null;
	}

}
