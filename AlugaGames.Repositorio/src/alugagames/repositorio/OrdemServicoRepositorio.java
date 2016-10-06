package alugagames.repositorio;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class OrdemServicoRepositorio extends RepositorioBase<OrdemServico> implements IOrdemServicoRepositorio{

	public OrdemServicoRepositorio() {
		super(OrdemServico.class);
	}

	@Override
	public int getNextCodigo() {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("Select COUNT(*) From OrdemServico");
		return Math.toIntExact((long)q.getSingleResult()) + 1;
	}

	public OrdemServico buscarPorAluguel(Aluguel aluguel) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select os from OrdemServico os where os.descricao = :descricao", OrdemServico.class);
		q.setParameter("descricao", "Aluguel " + aluguel.getCodigo());
		
		try{
			return (OrdemServico)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
