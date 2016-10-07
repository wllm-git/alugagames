package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerSexoValido implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		
		if(obj.getSexo() != 'M' && obj.getSexo() != 'F')
			return "Sexo inválido.";
		
		return null;
	}

}
