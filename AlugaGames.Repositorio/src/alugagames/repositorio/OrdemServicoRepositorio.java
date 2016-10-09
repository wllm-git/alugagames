package alugagames.repositorio;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.shared.StatusProduto;
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

	@Override
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

	@Override
	public OrdemServico buscarPorCodigo(int codigo) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select os from OrdemServico os where os.codigo = :codigo", OrdemServico.class);
		q.setParameter("codigo", codigo);
		
		try{
			return (OrdemServico)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public OrdemServico buscarPorCPFCliente(String cpf) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select os from OrdemServico os where os.cliente.cpf = :cpf", OrdemServico.class);
		q.setParameter("cpf", cpf);
		
		try{
			return (OrdemServico)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void atualizarStatusEquipamento(String numeroSerie, StatusProduto status) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("update Equipamento e set e.status = :status where e.numeroSerie = :numeroSerie");
		q.setParameter("numeroSerie", numeroSerie);
		q.setParameter("status", status);
		q.executeUpdate();
	}

	@Override
	public void atualizarStatusConsole(String numeroSerie, StatusProduto status) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("update Console c set c.status = :status where c.numeroSerie = :numeroSerie");
		q.setParameter("numeroSerie", numeroSerie);
		q.setParameter("status", status);
		q.executeUpdate();
	}
}
