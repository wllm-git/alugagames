package alugagames.core.os.regras;

import alugagames.core.funcionarios.Funcao;
import alugagames.core.os.OrdemServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaTerAtendenteValido implements IRegra<OrdemServico> {

	@Override
	public String validar(OrdemServico obj) {
		if(obj.getTecnico() == null)
			return "Atendente n�o informado";
		else if(obj.getTecnico().getFuncao() != Funcao.Atendente)
			return "Atendente inv�lido.";
		
		return null;
	}
}
