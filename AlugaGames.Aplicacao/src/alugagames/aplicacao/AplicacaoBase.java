package alugagames.aplicacao;

import alugagames.core.funcionarios.Funcionario;
import alugagames.repositorio.config.ConnectionManager;

public class AplicacaoBase {
	
	private Funcionario funcionarioLogado;
	
	protected Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	protected void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	void beginTransaction(){
		ConnectionManager.beginTransaction();
	}
	
    void commit(){
    	ConnectionManager.commit();
    }
    
    void rollback(){
    	ConnectionManager.rollback();
    }
    
    
}
