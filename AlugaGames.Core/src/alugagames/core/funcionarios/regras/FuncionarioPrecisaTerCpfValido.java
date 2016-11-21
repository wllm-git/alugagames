package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerCpfValido implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		
		if(obj.getCpf() == null || obj.getCpf().isEmpty())
			return "CPF n�o informado.";
		
		try {
			Long.parseLong(obj.getCpf());
			
			if(!FuncoesGerais.cpfValido(obj.getCpf()))
				return "CPF inv�lido.";
			
		} catch (Exception e) {
			return "CPF precisa conter apenas n�meros.";
		}
		
		
		return null;
	}

}
