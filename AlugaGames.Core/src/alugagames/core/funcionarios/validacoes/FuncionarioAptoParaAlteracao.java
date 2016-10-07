package alugagames.core.funcionarios.validacoes;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaEstaAtivo;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaExistirNoSistema;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class FuncionarioAptoParaAlteracao extends Validacao<Funcionario>{
	
	public FuncionarioAptoParaAlteracao(IFuncionarioRepositorio repositorio){
		adicionarRegra(new FuncionarioPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new FuncionarioPrecisaEstaAtivo());
	}
	
}
