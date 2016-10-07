package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioaoPodeTerOSEmAndamento implements IRegra<Funcionario> {

	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioaoPodeTerOSEmAndamento(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		
		int qtdOSEmAdamento = _repositorio.getQtdDeOrdemServicoEmAndamento(obj);
		if(qtdOSEmAdamento > 0)
			return "Funcionário " + obj.getNome() + " possui OS em andamento.";
		
		return null;
	}

}
