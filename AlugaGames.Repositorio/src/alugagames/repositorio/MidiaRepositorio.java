package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.midias.Midia;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class MidiaRepositorio extends RepositorioBase<Midia> implements IMidiaRepositorio{

	public MidiaRepositorio() {
		super(Midia.class);
	}

	@Override
	public void atualizarStatusMidia(Midia midia) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("update Midia m set m.status = :status where m.id = :id");
		q.setParameter("id", midia.getId());
		q.setParameter("status", midia.getStatus());
		q.executeUpdate();
	}

	@Override
	public Midia buscarPorNumeroSerie(String numeroSerie) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select m from Midia m where m.numeroSerie = :numeroSerie", Midia.class);
		q.setParameter("numeroSerie", numeroSerie);
		
		try{
			return (Midia)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
	
}
