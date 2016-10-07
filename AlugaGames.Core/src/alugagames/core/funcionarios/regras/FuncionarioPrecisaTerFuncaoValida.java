package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerFuncaoValida implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		if(obj.getFuncao() == null)
			return "Fun��o n�o informada.";
		
		return null;
	}

}
