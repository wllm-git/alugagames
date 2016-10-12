package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerCidadeValida implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		if(obj.getCidade() == null || obj.getCidade().isEmpty())
			return "Cidade não informada.";
			
		return null;
	}

}
