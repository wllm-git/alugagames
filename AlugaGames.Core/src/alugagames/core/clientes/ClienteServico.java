package alugagames.core.clientes;

import java.util.UUID;

import alugagames.core.clientes.repositorio.IClienteRepositorio;

public class ClienteServico {
	private IClienteRepositorio _repositorio;
	
	public ClienteServico(IClienteRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public Cliente buscarPorId(UUID id){
		return _repositorio.buscarPorID(id);
	}
}
