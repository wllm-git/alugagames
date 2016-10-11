package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.midias.Midia;
import alugagames.repositorio.config.ConnectionManager;

public class EquipamentoRepositorio extends RepositorioBase<Equipamento> implements IEquipamentoRepositorio{

	public EquipamentoRepositorio() {
		super(Equipamento.class);
	}

	@Override
	public void atualizarStatusEquipamento(Equipamento equipamento) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("update Equipamento e set e.status = :status where e.id = :id");
		q.setParameter("id", equipamento.getId());
		q.setParameter("status", equipamento.getStatus());
		q.executeUpdate();
	}

	@Override
	public Equipamento buscarPorNumeroSerie(String numeroSerie) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select e from Equipamento e where e.numeroSerie = :numeroSerie", Midia.class);
		q.setParameter("numeroSerie", numeroSerie);
		
		try{
			return (Equipamento)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
