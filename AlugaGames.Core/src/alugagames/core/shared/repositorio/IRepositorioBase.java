package alugagames.core.shared.repositorio;

import java.util.List;

public interface IRepositorioBase<T> {
	public void adicionar(T obj);
	public void alterar(T obj);
	public void excluir(T obj);
	public List<T> buscarTodos();
}
