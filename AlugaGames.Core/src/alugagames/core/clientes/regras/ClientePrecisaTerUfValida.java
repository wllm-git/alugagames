package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerUfValida implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		if(obj.getUf() == null || obj.getUf().isEmpty())
			return "UF não informada.";
		
		return null;
	}

}
