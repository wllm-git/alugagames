package alugagames.core.clientes;

import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.ServicoBase;

public class ClienteServico extends ServicoBase<Cliente>{
	private IClienteRepositorio _repositorio;
	
	public ClienteServico(IClienteRepositorio repositorio){
		super(repositorio);
		_repositorio = repositorio;
	}
	
}
