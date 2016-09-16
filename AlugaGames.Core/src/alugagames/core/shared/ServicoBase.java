package alugagames.core.shared;

import java.util.List;

import alugagames.core.shared.repositorio.IRepositorioBase;

public class ServicoBase<T>{
	private IRepositorioBase<T> _repositorio; 
	
	public ServicoBase(IRepositorioBase<T> repositorio){
		_repositorio = repositorio;
	}
	
	public void adicionar(T obj){
		_repositorio.adicionar(obj);
	}
	
	public void atualizar(T obj){
		_repositorio.alterar(obj);
	}
	
	public void excluir(T obj){
		_repositorio.excluir(obj);
	}
	
	public List<T> buscarTodos(){
		return _repositorio.buscarTodos();
	}
	
}
