package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class OrcamentoRepositorio extends RepositorioBase<Orcamento> implements IOrcamentoRepositorio{

	public OrcamentoRepositorio() {
		super(Orcamento.class);
	}

	@Override
	public int getNextCodigo() {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("Select COUNT(*) From Orcamento");
		return Math.toIntExact((long)q.getSingleResult()) + 1;
	}

	@Override
	public Orcamento buscarPorCodigo(int codigo) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select o from Orcamento o where o.codigo = :codigo", Orcamento.class);
		q.setParameter("codigo", codigo);
		
		try{
			return (Orcamento)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

}
