package alugagames.core.shared.repositorio;

import java.util.List;
import java.util.UUID;

public interface IRepositorioBase<T> {
	public void adicionar(T obj);
	public void excluir(T obj);
	public T buscarPorID(UUID id);
	public List<T> buscarTodos();
}
