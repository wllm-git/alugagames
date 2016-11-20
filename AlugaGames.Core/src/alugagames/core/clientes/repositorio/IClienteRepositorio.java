package alugagames.core.clientes.repositorio;

import java.util.List;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IClienteRepositorio extends IRepositorioBase<Cliente>{

	public Cliente buscarPorEmail(String email);

	public Cliente buscarPorCpf(String cpf);
	
	public List<Cliente> buscarPorNome(String nome);
	

}
