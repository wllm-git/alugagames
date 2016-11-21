package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerEmailValido implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		if(obj.getEmail() == null || obj.getEmail().isEmpty())
			return "E-mail não informado.";
		else if(!FuncoesGerais.emailValido(obj.getEmail()))
			return "E-mail inválido.";
		
		return null;
	}

}
