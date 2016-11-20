package alugagames.core.funcionarios.repositorio;

import java.util.List;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IFuncionarioRepositorio extends IRepositorioBase<Funcionario>{
	
	public Funcionario buscarPorEmail(String email);

	public Funcionario buscarPorCpf(String cpf);
	
	public int getQtdDeAlugueisEmAndamento(Funcionario funcionario);

	public int getQtdDeOrcamentosEmAndamento(Funcionario funcionario);

	public int getQtdDeOrdemServicoEmAndamento(Funcionario funcionario);

	public List<Funcionario> buscarPorNome(String nome);
}
