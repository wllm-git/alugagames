package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerCpfUnicoAlt implements IRegra<Funcionario> {

private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioPrecisaTerCpfUnicoAlt(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		
		Funcionario f = _repositorio.buscarPorCpf(obj.getCpf());
		if(f != null && !obj.getId().equals(f.getId()))
			return "CPF já está em uso.";
		
		return null;
	}

}
