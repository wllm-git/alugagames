package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class AluguelRepositorio extends RepositorioBase<Aluguel> implements IAluguelRepositorio{

	public AluguelRepositorio() {
		super(Aluguel.class);
	}

	@Override
	public int getNextCodigo() {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("Select COUNT(*) From Aluguel");
		return Math.toIntExact((long)q.getSingleResult()) + 1;
	}

	@Override
	public Aluguel buscarPorCodigo(int codigo) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select a from Aluguel a where a.codigo = :codigo", Aluguel.class);
		q.setParameter("codigo", codigo);
		
		try{
			return (Aluguel)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
