package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerSenhaValida implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		if(obj.getSenha() == null || obj.getSenha().isEmpty())
			return "Senha não informada.";
		return null;
	}

}
