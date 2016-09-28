package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.StatusAluguel;
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
	public Aluguel buscarReservaPorCodigo(int codigo) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select a from Aluguel a where a.codigo = :codigo and "
				+ " (a.status in ( :aberto , :reservado ) or (a.status = :cancelado and a.dataConfirmacao is null) )", Aluguel.class);
		q.setParameter("codigo", codigo);
		q.setParameter("aberto", StatusAluguel.Aberto);
		q.setParameter("reservado", StatusAluguel.Reservado);
		q.setParameter("cancelado", StatusAluguel.Cancelado);
		
		try{
			return (Aluguel)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Aluguel buscarAluguelPorCodigo(int codigo) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select a from Aluguel a where a.codigo = :codigo and "
				+ " (a.status not in ( :aberto , :reservado , :cancelado ) "
				+ " or (a.status = :cancelado and a.dataConfirmacao is not null ) )", Aluguel.class);
		 
		q.setParameter("codigo", codigo);
		q.setParameter("aberto", StatusAluguel.Aberto);
		q.setParameter("reservado", StatusAluguel.Reservado);
		q.setParameter("cancelado", StatusAluguel.Cancelado);
		
		try{
			return (Aluguel)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
