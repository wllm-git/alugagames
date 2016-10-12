package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerSenhaValida implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		if(obj.getSenha() == null || obj.getSenha().isEmpty())
			return "Senha não informada.";
		return null;
	}

}
