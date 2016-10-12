package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.repositorio.IJogoRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class JogoRepositorio extends RepositorioBase<Jogo> implements IJogoRepositorio {

	public JogoRepositorio() {
		super(Jogo.class);
	}

	@Override
	public Jogo buscarPorNome(String nome) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select j from Jogo j where j.nome = :nome", Jogo.class);
		q.setParameter("nome", nome);
		
		try{
			return (Jogo)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

}
