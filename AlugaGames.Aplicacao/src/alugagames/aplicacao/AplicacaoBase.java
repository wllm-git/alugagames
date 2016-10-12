package alugagames.aplicacao;

import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcionario;
import alugagames.repositorio.config.ConnectionManager;

public class AplicacaoBase {
	
	private Funcionario funcionarioLogado;
	private Cliente clienteLogado;
	
	protected Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	protected void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	protected Cliente getClienteLogado() {
		return clienteLogado;
	}

	protected void setClienteLogado(Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
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
