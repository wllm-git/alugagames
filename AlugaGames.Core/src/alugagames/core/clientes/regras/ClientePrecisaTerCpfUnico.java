package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerCpfUnico implements IRegra<Cliente> {

	private IClienteRepositorio _repositorio;
	
	public ClientePrecisaTerCpfUnico(IClienteRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Cliente obj) {
		
		Cliente c = _repositorio.buscarPorCpf(obj.getCpf());
		if(c != null)
			return "CPF já está em uso.";
		
		return null;
	}

}
