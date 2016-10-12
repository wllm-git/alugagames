package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerSexoValido implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		if(obj.getSexo() != 'M' && obj.getSexo() != 'F')
			return "Sexo inválido.";
		
		return null;
	}

}
