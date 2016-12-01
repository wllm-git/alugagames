package alugagames.core.alugueis.repositorio;

import java.util.List;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.clientes.Cliente;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IAluguelRepositorio extends IRepositorioBase<Aluguel>{

	public int getNextCodigo();
	
	public Aluguel buscarPorCodigo(int codigo);
	
	public List<Aluguel> buscarPorCliente(Cliente cliente);
}
