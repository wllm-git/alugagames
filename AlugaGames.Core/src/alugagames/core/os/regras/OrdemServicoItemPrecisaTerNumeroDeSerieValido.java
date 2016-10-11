package alugagames.core.os.regras;

import alugagames.core.os.OrdemServicoItem;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoItemPrecisaTerNumeroDeSerieValido implements IRegra<OrdemServicoItem> {

	@Override
	public String validar(OrdemServicoItem obj) {
		if(obj.getNumeroSerie() == null || obj.getNumeroSerie().isEmpty())
			return "Número de serie do item "+ obj.getDescricao() +" não informado.";
		return null;
	}

}
