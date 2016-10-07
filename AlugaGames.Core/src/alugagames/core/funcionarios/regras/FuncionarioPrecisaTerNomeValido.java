package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerNomeValido implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		if(obj.getNome() == null || obj.getNome().isEmpty())
			return "Nome não informado.";
		else if (obj.getNome().length() < 3)
			return "Nome precisa ter ao menos 3 caracteres.";
		else if(obj.getNome().length() > 100)
			return "Nome precisa ter no máximo 100 caracteres.";
		
		try {
			Double.parseDouble(obj.getNome());
			return "Nome não pode conter apenas números.";
		} catch (Exception e) {	}
		
		return null;
	}

}
