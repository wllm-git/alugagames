package alugagames.aplicacao;

import java.util.List;
import java.util.UUID;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.repositorio.ClienteRepositorio;

public class ClienteAplicacao  extends AplicacaoBase{
	private ClienteServico _clienteServico;
	
	public ClienteAplicacao(){
		_clienteServico = new ClienteServico(new ClienteRepositorio());
	}
	
	public List<String> adicionarCliente(Cliente cliente){
		
		beginTransaction();
		
		List<String> erros = _clienteServico.adicionarCliente(cliente);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> atualizarCliente(Cliente cliente){
		
		beginTransaction();
		
		List<String> erros = _clienteServico.atualizarCliente(cliente);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public Cliente buscarPorID(UUID id){
		return _clienteServico.buscarPorID(id);
	}
	
	public List<Cliente> buscarTodos(){
		return _clienteServico.buscarTodos();
	}
	
	public Cliente logar(String email, String senha) throws Exception{
		
		Cliente cliente = _clienteServico.logar(email, senha);
		this.setClienteLogado(cliente);
		
		return cliente;
	}
}
