package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class ConsoleRepositorio extends RepositorioBase<Console> implements IConsoleRepositorio {

	public ConsoleRepositorio() {
		super(Console.class);
	}

	@Override
	public void AtualizarStatusConsole(Console console) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("update Console c set c.status = :status where c.id = :id");
		q.setParameter("id", console.getId());
		q.setParameter("status", console.getStatus());
		q.executeUpdate();
	}
	
}
