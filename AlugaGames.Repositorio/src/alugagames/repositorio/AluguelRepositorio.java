package alugagames.repositorio;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.consoles.Console;
import alugagames.core.equipamentos.Equipamento;
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
}
