package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerEmailUnico implements IRegra<Cliente> {

	private IClienteRepositorio _repositorio;
	
	public ClientePrecisaTerEmailUnico(IClienteRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Cliente obj) {
		
		Cliente c = _repositorio.buscarPorEmail(obj.getEmail());
		if(c != null)
			return "E-mail já está em uso.";
		
		return null;
	}

}
