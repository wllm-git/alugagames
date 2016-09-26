package alugagames.repositorio;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import alugagames.core.acessorios.Acessorio;
import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.consoles.Console;
import alugagames.core.midias.Midia;
import alugagames.core.shared.Produto;
import alugagames.core.shared.StatusProduto;
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
	public void AtualizarStatusProduto(Produto p) {
		if(p instanceof Console){
			//Console c = (Console) p;
			//atualizarStatus("Console", c.getId(), c.getStatus());
		}else if (p instanceof Midia){
			Midia m = (Midia) p;
			atualizarStatus("Midia", m.getId(), m.getStatus());
		}else{
			Acessorio a = (Acessorio) p;
			atualizarStatus("Acessorio", a.getId(), a.getStatus());
		}
	}

	private void atualizarStatus(String classe, UUID id, StatusProduto status){
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("update "+ classe +" p set p.status = :status where p.id = :id");
		q.setParameter("id", id);
		q.setParameter("status", status);
		q.executeUpdate();
	}
}
