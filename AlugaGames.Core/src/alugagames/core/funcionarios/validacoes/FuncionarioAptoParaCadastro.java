package alugagames.core.funcionarios.validacoes;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaSerMaiorDe18Anos;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerCpfUnico;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerCpfValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerEmailUnico;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerEmailValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerFuncaoValida;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerNomeValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerSenhaValida;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerSexoValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerTelefoneValido;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class FuncionarioAptoParaCadastro extends Validacao<Funcionario>{
	
	public FuncionarioAptoParaCadastro(IFuncionarioRepositorio repositorio){
		adicionarRegra(new FuncionarioPrecisaTerNomeValido());
		adicionarRegra(new FuncionarioPrecisaTerSenhaValida());
		adicionarRegra(new FuncionarioPrecisaTerEmailValido());
		adicionarRegra(new FuncionarioPrecisaTerEmailUnico(repositorio));
		adicionarRegra(new FuncionarioPrecisaTerCpfValido());
		adicionarRegra(new FuncionarioPrecisaTerCpfUnico(repositorio));
		adicionarRegra(new FuncionarioPrecisaTerTelefoneValido());
		adicionarRegra(new FuncionarioPrecisaTerSexoValido());
		adicionarRegra(new FuncionarioPrecisaSerMaiorDe18Anos());
		adicionarRegra(new FuncionarioPrecisaTerFuncaoValida());
	}
	
}
