package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerCpfUnico implements IRegra<Funcionario> {

	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioPrecisaTerCpfUnico(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		
		Funcionario f = _repositorio.buscarPorCpf(obj.getCpf());
		if(f != null)
			return "Cpf já está em uso.";
		
		return null;
	}

}
