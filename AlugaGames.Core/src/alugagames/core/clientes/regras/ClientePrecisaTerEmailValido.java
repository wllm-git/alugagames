package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.FuncoesGerais;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerEmailValido implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		if(obj.getEmail() == null || obj.getEmail().isEmpty())
			return "Email não informado.";
		else if(!FuncoesGerais.emailValido(obj.getEmail()))
			return "Email inválido.";
		
		return null;
	}

}
