package alugagames.aplicacao;

import java.util.List;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.AluguelServico;
import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.consoles.ConsoleServico;
import alugagames.repositorio.AluguelRepositorio;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.ConsoleRepositorio;

public class AluguelAplicacao extends AplicacaoBase{
	private AluguelServico _aluguelServico;
	
	public AluguelAplicacao(){
		ClienteServico clienteServico = new ClienteServico(new ClienteRepositorio());
		ConsoleServico consoleServico = new ConsoleServico(new ConsoleRepositorio());
		_aluguelServico = new AluguelServico(new AluguelRepositorio(), clienteServico, consoleServico);
	}
	
	public Aluguel abrirReserva(Cliente cliente){
		
		beginTransaction();
		try{
			Aluguel aluguel = _aluguelServico.abrirReserva(cliente);
			commit();
			return aluguel;
		}
		catch(RuntimeException ex ){
			rollback();
			throw ex;
		}
	}
	
	public List<String> confirmarReserva(Aluguel reserva){
		beginTransaction();
		
		List<String> erros = _aluguelServico.confirmarReserva(reserva);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
}
