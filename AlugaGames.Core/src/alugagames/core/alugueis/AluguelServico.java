package alugagames.core.alugueis;

import java.util.List;

import alugagames.core.acessorios.Acessorio;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.clientes.Cliente;
import alugagames.core.consoles.Console;
import alugagames.core.midias.Midia;

public class AluguelServico {
	private IAluguelRepositorio _repositorio;
	
	public AluguelServico(IAluguelRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public Aluguel abrirReserva(Cliente cliente){
		return null;
	}
	
	public List<String> confirmarReserva(Aluguel aluguel){
		return null;
	}
	
	public List<String> confirmarAluguel(Aluguel aluguel){
		return null;
	}
	
	public List<String> finalizarAluguel(Aluguel aluguel){
		return null;
	}
	
	public List<String> cancelar(Aluguel aluguel){
		return null;
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
