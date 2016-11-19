package alugagames.repositorio;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import alugagames.core.shared.repositorio.IRepositorioBase;
import alugagames.repositorio.config.ConnectionManager;

public class RepositorioBase<T> implements IRepositorioBase<T>{
	
	private final Class<T> typeClass;
	
	public RepositorioBase(Class<T> typeClass){
		this.typeClass = typeClass;
	}

	@Override
	public void adicionar(T obj) {
		EntityManager em = ConnectionManager.getEntityManager();
		em.merge(obj);
	}


	@Override
	public void excluir(T obj) {
		EntityManager em = ConnectionManager.getEntityManager();
		em.remove(obj);
	}

	@Override
	public T buscarPorID(UUID id) {
		EntityManager em = ConnectionManager.getEntityManager();
		return em.find(typeClass, id);
	}
	
	@Override
	public List<T> buscarTodos() {
		EntityManager em = ConnectionManager.getEntityManager();
		return em.createQuery("Select a from " + typeClass.getName() + " a", typeClass).getResultList();
	}
	
}
