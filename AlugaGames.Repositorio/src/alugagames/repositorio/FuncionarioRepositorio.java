package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class FuncionarioRepositorio extends RepositorioBase<Funcionario> implements IFuncionarioRepositorio {

	public FuncionarioRepositorio() {
		super(Funcionario.class);
	}

	@Override
	public Funcionario buscarPorEmail(String email) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select f from Funcionario f where f.email = :email", Funcionario.class);
		q.setParameter("email", email);
		
		try{
			return (Funcionario)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	
}
