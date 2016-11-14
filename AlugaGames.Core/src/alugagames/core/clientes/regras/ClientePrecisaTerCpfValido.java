package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerCpfValido implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
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
