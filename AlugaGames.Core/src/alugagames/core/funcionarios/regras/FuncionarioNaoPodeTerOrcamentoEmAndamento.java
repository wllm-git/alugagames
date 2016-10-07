package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioNaoPodeTerOrcamentoEmAndamento implements IRegra<Funcionario> {

	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioNaoPodeTerOrcamentoEmAndamento(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		
		int qtdOrcamentoEmAdamento = _repositorio.getQtdDeOrcamentosEmAndamento(obj);
		if(qtdOrcamentoEmAdamento > 0)
			return "Funcionário "+ obj.getNome() +" possui "+ qtdOrcamentoEmAdamento +" orçamento(s) em andamento.";
		
		return null;
	}

}
