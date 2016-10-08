package alugagames.aplicacao;

import java.util.List;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.AluguelServico;
import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.consoles.ConsoleServico;
import alugagames.core.equipamentos.EquipamentoServico;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.midias.MidiaServico;
import alugagames.core.os.OrdemServicoServico;
import alugagames.repositorio.AluguelRepositorio;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.ConsoleRepositorio;
import alugagames.repositorio.EquipamentoRepositorio;
import alugagames.repositorio.MidiaRepositorio;
import alugagames.repositorio.OrdemServicoRepositorio;

public class AluguelAplicacao extends AplicacaoBase{
	private AluguelServico _aluguelServico;
	
	public AluguelAplicacao(){
		ClienteServico clienteServico = new ClienteServico(new ClienteRepositorio());
		ConsoleServico consoleServico = new ConsoleServico(new ConsoleRepositorio());
		MidiaServico midiaServico = new MidiaServico(new MidiaRepositorio());
		EquipamentoServico equipamentoServico = new EquipamentoServico(new EquipamentoRepositorio());
		FuncionarioServico atendenteServico = new FuncionarioServico(new FuncionarioRepositorio());
		OrdemServicoServico ordemServicoServico = new OrdemServicoServico(new OrdemServicoRepositorio()); 
		
		_aluguelServico = new AluguelServico(new AluguelRepositorio(), 
													clienteServico, atendenteServico, consoleServico, 
													midiaServico, equipamentoServico, ordemServicoServico);
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
		if(!erros.isEmpty())
			rollback();
		else
			commit();
		
		return erros;
	}
	
	public List<String> confirmarAluguel(Aluguel aluguel){
		beginTransaction();
		
		List<String> erros = _aluguelServico.confirmarAluguel(aluguel);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
		
		return erros;
	}
	
	public List<String> finalizarAluguel(Aluguel aluguel){
		beginTransaction();
		
		List<String> erros = _aluguelServico.finalizarAluguel(aluguel);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
		
		return erros;
	}
	
	public Aluguel buscarReservaPorCodigo(int codigo){
		return _aluguelServico.buscarReservaPorCodigo(codigo);
	}
	
	public Aluguel buscarAluguelPorCodigo(int codigo){
		return _aluguelServico.buscarAluguelPorCodigo(codigo);
	}
}
