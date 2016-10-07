package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerEmailUnicoAlt implements IRegra<Funcionario> {

private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioPrecisaTerEmailUnicoAlt(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		
		Funcionario f = _repositorio.buscarPorEmail(obj.getEmail());
		if(f != null && !obj.getId().equals(f.getId()))
			return "Email já está em uso.";
		
		return null;
	}

}
