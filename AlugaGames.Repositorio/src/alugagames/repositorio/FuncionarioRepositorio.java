package alugagames.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import alugagames.core.alugueis.StatusAluguel;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.orcamentos.StatusOrcamento;
import alugagames.core.os.StatusOS;
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

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		EntityManager em = ConnectionManager.getEntityManager();
		
		Query q = em.createQuery("Select f from Funcionario f where f.cpf = :cpf", Funcionario.class);
		q.setParameter("cpf", cpf);
		
		try{
			return (Funcionario)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public int getQtdDeAlugueisEmAndamento(Funcionario funcionario) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("Select COUNT(*) From Aluguel a where a.status = :status and a.atendente.id = :id");
		
		q.setParameter("status", StatusAluguel.Confirmado);
		q.setParameter("id", funcionario.getId());
		
		return Math.toIntExact((Long)q.getSingleResult());
	}

	@Override
	public int getQtdDeOrcamentosEmAndamento(Funcionario funcionario) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("Select COUNT(*) From Orcamento o where o.status in (:recebido, :avaliando) and "
				+ " (o.atendente.id = :id_atedente or o.tecnico.id = :id_tecnico)");
		
		q.setParameter("recebido", StatusOrcamento.Recebido);
		q.setParameter("avaliando", StatusOrcamento.Avaliando);
		q.setParameter("id_atedente", funcionario.getId());
		q.setParameter("id_tecnico", funcionario.getId());
		
		return Math.toIntExact((Long)q.getSingleResult());
	}

	@Override
	public int getQtdDeOrdemServicoEmAndamento(Funcionario funcionario) {
		EntityManager em = ConnectionManager.getEntityManager();
		Query q = em.createQuery("Select COUNT(*) From OrdemServico os where os.status != :fechada) and "
				+ " (os.atendente.id = :id_atedente or os.tecnico.id = :id_tecnico)");
		
		q.setParameter("fechada", StatusOS.Fechada);
		q.setParameter("id_atedente", funcionario.getId());
		q.setParameter("id_tecnico", funcionario.getId());
		
		return Math.toIntExact((Long)q.getSingleResult());
	}

}

