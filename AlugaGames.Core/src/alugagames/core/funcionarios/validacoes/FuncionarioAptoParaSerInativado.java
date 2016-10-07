package alugagames.core.funcionarios.validacoes;

import java.util.UUID;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.regras.FuncionarioNaoPodeInativarASeMesmo;
import alugagames.core.funcionarios.regras.FuncionarioNaoPodeTerAluguelEmAndamento;
import alugagames.core.funcionarios.regras.FuncionarioNaoPodeTerOrcamentoEmAndamento;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaExistirNoSistema;
import alugagames.core.funcionarios.regras.FuncionarioaoPodeTerOSEmAndamento;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class FuncionarioAptoParaSerInativado extends Validacao<Funcionario>{
	public FuncionarioAptoParaSerInativado(IFuncionarioRepositorio repositorio, UUID idFuncionarioLogado){
		adicionarRegra(new FuncionarioPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new FuncionarioNaoPodeInativarASeMesmo(idFuncionarioLogado));
		adicionarRegra(new FuncionarioNaoPodeTerAluguelEmAndamento(repositorio));
		adicionarRegra(new FuncionarioNaoPodeTerOrcamentoEmAndamento(repositorio));
		adicionarRegra(new FuncionarioaoPodeTerOSEmAndamento(repositorio));
	}
}
