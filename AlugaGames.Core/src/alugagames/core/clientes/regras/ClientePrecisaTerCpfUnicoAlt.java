package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerCpfUnicoAlt implements IRegra<Cliente> {

	private IClienteRepositorio _repositorio;
	
	public ClientePrecisaTerCpfUnicoAlt(IClienteRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Cliente obj) {
		
		Cliente c = _repositorio.buscarPorCpf(obj.getCpf());
		if(c != null && !c.getId().equals(obj.getId()))
			return "Cpf já está em uso.";
		
		return null;
	}

}
