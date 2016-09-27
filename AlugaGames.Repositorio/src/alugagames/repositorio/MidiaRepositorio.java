package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
}
