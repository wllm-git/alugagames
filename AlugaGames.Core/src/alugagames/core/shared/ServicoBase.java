package alugagames.core.shared;

import java.util.List;
import java.util.UUID;

import alugagames.core.shared.repositorio.IRepositorioBase;

public class ServicoBase<T>{
	private IRepositorioBase<T> _repositorio; 
	
	public ServicoBase(IRepositorioBase<T> repositorio){
		_repositorio = repositorio;
	}
	
	public T buscarPorID(UUID id){
		return _repositorio.buscarPorID(id);
	}
	
	public List<T> buscarTodos(){
		return _repositorio.buscarTodos();
	}
	
}
