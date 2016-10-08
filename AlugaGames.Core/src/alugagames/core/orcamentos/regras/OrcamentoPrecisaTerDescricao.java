package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaTerDescricao implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		if(obj.getDescricao() == null || obj.getDescricao().isEmpty())
			return "Descrição não informada.";
		else if(obj.getDescricao().length() < 15)
			return "Descrição deve ter ao menos 15 caracteres.";
		else if(obj.getDescricao().length() > 500)
			return "Aqui não é redação do ENEM.";
		
		return null;
	}

}
