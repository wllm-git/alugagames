package alugagames.core.alugueis;

import java.util.Date;
import java.util.List;

import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerCancelado;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerConfirmado;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerFinalizado;
import alugagames.core.alugueis.validacoes.ReservaAptaParaSerConfirmada;
import alugagames.core.alugueis.validacoes.ReservaAptaParaSerIniciada;
import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.consoles.Console;
import alugagames.core.consoles.ConsoleServico;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.EquipamentoServico;
import alugagames.core.midias.Midia;
import alugagames.core.midias.MidiaServico;

public class AluguelServico {
	private IAluguelRepositorio _repositorio;
	private ClienteServico _clienteServico;
	private ConsoleServico _consoleServico;
	private MidiaServico _midiaServico;
	private EquipamentoServico _equipamentoServico;
	
	public AluguelServico(IAluguelRepositorio repositorio, ClienteServico clienteServico, 
			ConsoleServico consoleServico, MidiaServico midiaServico, EquipamentoServico acessorioServico){
		_repositorio = repositorio;
		_clienteServico = clienteServico;
		_consoleServico = consoleServico;
		_midiaServico = midiaServico;
		_equipamentoServico = acessorioServico;
	}
	
	public Aluguel abrirReserva(Cliente cliente){
		
		Aluguel aluguel = new Aluguel();
		aluguel.setCodigo(_repositorio.getNextCodigo());
		aluguel.setCliente(cliente);
		aluguel.setDataAbertura(new Date());
		
		List<String> erros = new ReservaAptaParaSerIniciada(_clienteServico).validar(aluguel); 
		
		if(!erros.isEmpty()){
			StringBuilder msg = new StringBuilder();
			for(String err : erros){
				msg.append(err);
				msg.append("\n");
			}
			throw new RuntimeException(msg.toString());
		}else
			_repositorio.adicionar(aluguel);
		
		return aluguel;
	}
	
	public List<String> confirmarReserva(Aluguel aluguel){
		
		List<String> erros = new ReservaAptaParaSerConfirmada().validar(aluguel);
		if(!erros.isEmpty())
			return erros;
				
		for(Console c : aluguel.getConsoles()){
			erros.addAll(_consoleServico.reservar(c));
		}
		
		for(Midia m : aluguel.getMidias()){
			erros.addAll(_midiaServico.reservar(m));
		}
				
		for(Equipamento e : aluguel.getEquipamentos()){
			erros.addAll(_equipamentoServico.reservar(e));
		}
		
		
		if(erros.isEmpty()){
			aluguel.setStatus(StatusAluguel.Confirmado);
			aluguel.setDataAbertura(new Date());
			
			_repositorio.alterar(aluguel);
		}
		
		return erros;
	}
	
	public List<String> confirmarAluguel(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerConfirmado(_repositorio).validar(aluguel);
		
		if(!erros.isEmpty())
			return erros;
		
		for(Console c : aluguel.getConsoles()){
			erros.addAll(_consoleServico.alugar(c));
		}
		
		for(Midia m : aluguel.getMidias()){
			erros.addAll(_midiaServico.alugar(m));
		}
				
		for(Equipamento e : aluguel.getEquipamentos()){
			erros.addAll(_equipamentoServico.alugar(e));
		}
		
		aluguel.setStatus(StatusAluguel.Confirmado);
		aluguel.setDataConfirmacao(new Date());
		
		if(erros.isEmpty())
			_repositorio.alterar(aluguel);
		
		return erros;
	}
	
	public List<String> finalizarAluguel(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerFinalizado().validar(aluguel);
		
		return erros;
	}
	
	public List<String> cancelar(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerCancelado(_repositorio).validar(aluguel);
		
		if(!erros.isEmpty())
			return erros;
		
		for(Console c : aluguel.getConsoles()){
			_consoleServico.liberar(c);
		}
		
		for(Midia m : aluguel.getMidias()){
			_midiaServico.liberar(m);
		}
				
		for(Equipamento e : aluguel.getEquipamentos()){
			_equipamentoServico.liberar(e);
		}
		
		aluguel.setStatus(StatusAluguel.Cancelado);
		aluguel.setDataFechamento(new Date());
		
		_repositorio.alterar(aluguel);
		
		return erros;
	}
	
	public Aluguel buscarReservaPorCodigo(int codigo){
		Aluguel aluguel = _repositorio.buscarPorCodigo(codigo); 
		
		if(aluguel != null){
			if(!aluguel.isAluguel())
				return aluguel;
			
			aluguel = null;
		}
		
		return aluguel;
	}
	
	public Aluguel buscarAluguelPorCodigo(int codigo){
		Aluguel aluguel = _repositorio.buscarPorCodigo(codigo); 
		
		if(aluguel != null){
			if(aluguel.isAluguel())
				return aluguel;
			
			aluguel = null;
		}
		
		return aluguel;
	}
	
	public List<String> adicionarConsoles(Aluguel aluguel, List<Console> consoles){
		return null;
	}
	
	public List<String> adicionarMidias(Aluguel aluguel, List<Midia> midias){
		return null;
	}
	
	public List<String> adicionarAcessorios(Aluguel aluguel, List<Equipamento> acessorios){
		return null;
	}
	
	public List<String> removerConsoles(Aluguel aluguel, List<Console> consoles){
		return null;
	}
	
	public List<String> removerMidias(Aluguel aluguel, List<Midia> midias){
		return null;
	}
	
	public List<String> removerAcessorios(Aluguel aluguel, List<Equipamento> acessorios){
		return null;
	}
}
