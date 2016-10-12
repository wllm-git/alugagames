package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerNomeValido implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		if(obj.getNome() == null || obj.getNome().isEmpty())
			return "Nome n�o informado.";
		else if (obj.getNome().length() < 3)
			return "Nome precisa ter ao menos 3 caracteres.";
		else if(obj.getNome().length() > 100)
			return "Nome precisa ter no m�ximo 100 caracteres.";
		
		try {
			Double.parseDouble(obj.getNome());
			return "Nome n�o pode conter apenas n�meros.";
		} catch (Exception e) {	}
		
		return null;
	}

}
