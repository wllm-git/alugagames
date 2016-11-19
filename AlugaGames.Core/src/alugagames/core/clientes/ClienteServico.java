package alugagames.core.clientes;

import java.util.List;

import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.clientes.validacoes.ClienteAptoParaCadastro;
import alugagames.core.shared.CriptografiaDES;
import alugagames.core.shared.ServicoBase;

public class ClienteServico extends ServicoBase<Cliente>{
	private IClienteRepositorio _repositorio;
	
	public ClienteServico(IClienteRepositorio repositorio){
		super(repositorio);
		_repositorio = repositorio;
	}
	
	public List<String> adicionarCliente(Cliente cliente) {
		
		List<String> erros = new ClienteAptoParaCadastro(_repositorio).validar(cliente);
		if(erros.isEmpty()){
			cliente.setSenha(CriptografiaDES.encriptar(cliente.getSenha()));
			_repositorio.adicionar(cliente);
		}
		
		return erros;
	}


	public Cliente buscarPorEmail(String email){
		Cliente cliente = _repositorio.buscarPorEmail(email);
		return cliente;
	}

	public Cliente logar(String email, String senha)  throws Exception {
		Cliente cliente = _repositorio.buscarPorEmail(email);
		
		if(cliente == null)
			throw new Exception("e-mail e/ou senha inválidos.");
		else{
			String senhaD = CriptografiaDES.decriptar(cliente.getSenha());
			
			if(!senhaD.equals(senha))
				throw new Exception("e-mail e/ou senha inválidos.");
		}
		
		return cliente;
	}
}
