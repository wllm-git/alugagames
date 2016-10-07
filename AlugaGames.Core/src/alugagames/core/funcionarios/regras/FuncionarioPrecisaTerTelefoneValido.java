package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerTelefoneValido implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		if(obj.getTelefone() == null || obj.getTelefone().isEmpty())
			return "Telefone não informado.";
		
		try {
			Long.parseLong(obj.getTelefone());
		} catch (Exception e) {
			return "Telefone precisa conter apenas números.";
		}
		
		if(obj.getTelefone().length() >= 8)
			return "Telefone inválido.";
		
		return null;
	}

}
