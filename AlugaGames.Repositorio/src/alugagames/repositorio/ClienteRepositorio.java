package alugagames.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class ClienteRepositorio extends RepositorioBase<Cliente> implements IClienteRepositorio{

	public ClienteRepositorio() {
		super(Cliente.class);
	}

	@Override
	public Cliente buscarPorEmail(String email) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select c from Cliente c where c.email = :email", Cliente.class);
		q.setParameter("email", email);
		
		try{
			return (Cliente)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select c from Cliente c where c.cpf = :cpf", Cliente.class);
		q.setParameter("cpf", cpf);
		
		try{
			return (Cliente)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		try {
			return em.createQuery("from Cliente where upper(nome) like :nome", Cliente.class)
										.setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	
	}

}
