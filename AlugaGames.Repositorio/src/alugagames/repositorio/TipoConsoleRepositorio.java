package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class TipoConsoleRepositorio extends RepositorioBase<TipoConsole> implements ITipoConsoleRepositorio{

	public TipoConsoleRepositorio() {
		super(TipoConsole.class);
	}

	@Override
	public TipoConsole buscarPorNome(String nome) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select tc from TipoConsole tc where tc.nome = :nome", TipoConsole.class);
		q.setParameter("nome", nome);
		
		try{
			return (TipoConsole)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

}
