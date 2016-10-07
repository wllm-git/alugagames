package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioNaoPodeTerAluguelEmAndamento implements IRegra<Funcionario> {

	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioNaoPodeTerAluguelEmAndamento(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		
		int qtdAluguelEmAndamento = _repositorio.getQtdDeAlugueisEmAndamento(obj);
		if(qtdAluguelEmAndamento > 0)
			return "Funcionário "+ obj.getNome() +" possui aluguel em andamento.";
		
		return null;
	}

}
