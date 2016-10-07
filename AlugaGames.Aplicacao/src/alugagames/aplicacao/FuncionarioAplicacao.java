package alugagames.aplicacao;

import java.util.List;

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
	
	public Funcionario logar(String email, String senha) throws Exception{
		if(this.getFuncionarioLogado() != null)
			throw new Exception("O funcion�rio " + this.getFuncionarioLogado().getNome() + " j� est� logado.");
		
		Funcionario funcionario = _funcionarioServico.logar(email, senha);
		this.setFuncionarioLogado(funcionario);
		
		return funcionario;
	}
}
