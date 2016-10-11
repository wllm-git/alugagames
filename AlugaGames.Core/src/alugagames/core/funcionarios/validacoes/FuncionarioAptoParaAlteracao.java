package alugagames.core.funcionarios.validacoes;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaEstarAtivo;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaExistirNoSistema;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaSerMaiorDe18Anos;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerCpfUnicoAlt;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerCpfValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerEmailUnicoAlt;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerEmailValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerFuncaoValida;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerNomeValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerSenhaEncriptada;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerSenhaValida;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerSexoValido;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaTerTelefoneValido;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class FuncionarioAptoParaAlteracao extends Validacao<Funcionario>{
	
	public FuncionarioAptoParaAlteracao(IFuncionarioRepositorio repositorio){
		adicionarRegra(new FuncionarioPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new FuncionarioPrecisaEstarAtivo());		
		adicionarRegra(new FuncionarioPrecisaTerNomeValido());
		adicionarRegra(new FuncionarioPrecisaTerSenhaValida());
		adicionarRegra(new FuncionarioPrecisaTerSenhaEncriptada(repositorio));
		adicionarRegra(new FuncionarioPrecisaTerEmailValido());
		adicionarRegra(new FuncionarioPrecisaTerEmailUnicoAlt(repositorio));
		adicionarRegra(new FuncionarioPrecisaTerCpfValido());
		adicionarRegra(new FuncionarioPrecisaTerCpfUnicoAlt(repositorio));
		adicionarRegra(new FuncionarioPrecisaTerTelefoneValido());
		adicionarRegra(new FuncionarioPrecisaTerSexoValido());
		adicionarRegra(new FuncionarioPrecisaSerMaiorDe18Anos());
		adicionarRegra(new FuncionarioPrecisaTerFuncaoValida());
	}
	
}
