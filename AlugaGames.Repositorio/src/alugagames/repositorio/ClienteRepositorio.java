package alugagames.repositorio;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.repositorio.IClienteRepositorio;

public class ClienteRepositorio extends RepositorioBase<Cliente> implements IClienteRepositorio{

	public ClienteRepositorio() {
		super(Cliente.class);
	}

}
