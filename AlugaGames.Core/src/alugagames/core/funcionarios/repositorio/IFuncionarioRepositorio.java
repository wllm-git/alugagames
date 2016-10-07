package alugagames.core.funcionarios.repositorio;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IFuncionarioRepositorio extends IRepositorioBase<Funcionario>{
	public Funcionario buscarPorEmail(String email);
}
