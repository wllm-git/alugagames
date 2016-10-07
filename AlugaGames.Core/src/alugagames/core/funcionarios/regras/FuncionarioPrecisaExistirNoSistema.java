package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaExistirNoSistema implements IRegra<Funcionario> {
	IFuncionarioRepositorio _repositorio;
	
	public FuncionarioPrecisaExistirNoSistema(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		Funcionario f = _repositorio.buscarPorID(obj.getId());
		if(f == null)
			return "Funcionário " + obj.getNome() + " não existe no sistema.";
		
		return null;
	}

}
