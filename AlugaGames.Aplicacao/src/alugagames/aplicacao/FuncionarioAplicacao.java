package alugagames.aplicacao;

import java.util.List;
import java.util.UUID;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.repositorio.FuncionarioRepositorio;

public class FuncionarioAplicacao extends AplicacaoBase{
private FuncionarioServico _funcionarioServico;
	
	public FuncionarioAplicacao(){
		_funcionarioServico = new FuncionarioServico(new FuncionarioRepositorio());
	}
	
	public List<String> cadastrar(Funcionario funcionario){
		
		beginTransaction();
		
		List<String> erros = _funcionarioServico.adicionarFuncionario(funcionario);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> atualizar(Funcionario funcionario){
		
		beginTransaction();
		
		List<String> erros = _funcionarioServico.atualizarFuncionario(funcionario);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> inativar(Funcionario funcionario, Funcionario funcionarioLogado){
		
		beginTransaction();
		
		UUID id = null;
		if(funcionarioLogado != null)
			id = funcionarioLogado.getId();
		
		List<String> erros = _funcionarioServico.inativarFuncionario(funcionario, id);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> ativar(Funcionario funcionario){
		
		beginTransaction();
		
		List<String> erros = _funcionarioServico.ativarFuncionario(funcionario);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public Funcionario logar(String email, String senha) throws Exception{
		
		Funcionario funcionario = _funcionarioServico.logar(email, senha);
		
		return funcionario;
	}
}
