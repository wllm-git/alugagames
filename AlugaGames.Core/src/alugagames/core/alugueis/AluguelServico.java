package alugagames.core.alugueis;

import java.util.Date;
import java.util.List;

import alugagames.core.acessorios.Acessorio;
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
import alugagames.core.midias.Midia;
import alugagames.core.shared.StatusProduto;

public class AluguelServico {
	private IAluguelRepositorio _repositorio;
	private ClienteServico _clienteServico;
	private ConsoleServico _consoleServico;
	
	public AluguelServico(IAluguelRepositorio repositorio, ClienteServico clienteServico, ConsoleServico consoleServico){
		_repositorio = repositorio;
		_clienteServico = clienteServico;
		_consoleServico = consoleServico;
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
		
		aluguel.setStatus(StatusAluguel.Confirmado);
		aluguel.setDataConfirmacao(new Date());
		
		for(Console c : aluguel.getConsoles()){
			_consoleServico.reservar(c);
		}
		
		for(Midia m : aluguel.getMidias()){
			m.setStatus(StatusProduto.Reservado);
			_repositorio.AtualizarStatusProduto(m);
		}
				
		for(Acessorio a : aluguel.getAcessorios()){
			a.setStatus(StatusProduto.Reservado);
			_repositorio.AtualizarStatusProduto(a);
		}
		
		_repositorio.alterar(aluguel);
		
		return erros;
	}
	
	public List<String> confirmarAluguel(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerConfirmado().validar(aluguel);
		erros = new AluguelAptoParaSerConfirmado().validar(aluguel);
		
		return erros;
	}
	
	public List<String> finalizarAluguel(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerFinalizado().validar(aluguel);
		
		return erros;
	}
	
	public List<String> cancelar(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerCancelado().validar(aluguel);
		
		return erros;
	}
	
	public Aluguel buscarReservaPorCodigo(int codigo){
		return null;
	}
	
	public Aluguel buscarAluguelPorCodigo(int codigo){
		return null;
	}
	
	public List<String> adicionarConsoles(Aluguel aluguel, List<Console> consoles){
		return null;
	}
	
	public List<String> adicionarMidias(Aluguel aluguel, List<Midia> midias){
		return null;
	}
	
	public List<String> adicionarAcessorios(Aluguel aluguel, List<Acessorio> acessorios){
		return null;
	}
	
	public List<String> removerConsoles(Aluguel aluguel, List<Console> consoles){
		return null;
	}
	
	public List<String> removerMidias(Aluguel aluguel, List<Midia> midias){
		return null;
	}
	
	public List<String> removerAcessorios(Aluguel aluguel, List<Acessorio> acessorios){
		return null;
	}
}
