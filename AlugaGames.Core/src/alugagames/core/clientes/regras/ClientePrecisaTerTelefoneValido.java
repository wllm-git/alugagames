package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerTelefoneValido implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		if(obj.getTelefone() == null || obj.getTelefone().isEmpty())
			return null;
		
		try {
			Long.parseLong(obj.getTelefone());
		} catch (Exception e) {
			return "Telefone precisa conter apenas números.";
		}
		
		if(obj.getTelefone().length() < 8)
			return "Telefone inválido.";
		
		return null;
	}

}
