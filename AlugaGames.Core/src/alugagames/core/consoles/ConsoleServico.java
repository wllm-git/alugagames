package alugagames.core.consoles;

import java.util.List;

import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.consoles.validacoes.ConsoleAptoParaAlteracao;
import alugagames.core.consoles.validacoes.ConsoleAptoParaAlugar;
import alugagames.core.consoles.validacoes.ConsoleAptoParaCadastro;
import alugagames.core.consoles.validacoes.ConsoleAptoParaReserva;
import alugagames.core.shared.ServicoBase;
import alugagames.core.shared.StatusProduto;

public class ConsoleServico extends ServicoBase<Console> {
	private IConsoleRepositorio _repositorio;
	
	public ConsoleServico(IConsoleRepositorio repositorio) {
		super(repositorio);
		_repositorio = repositorio;
	}

	public List<String> adicionarConsole(Console console){
		
		List<String> erros = new ConsoleAptoParaCadastro().validar(console);
		if(erros.isEmpty())
			_repositorio.adicionar(console);
		
		return erros;
	}
	
	public List<String> atualizarConsole(Console console){
		
		List<String> erros = new ConsoleAptoParaAlteracao().validar(console);
		if(erros.isEmpty())
			_repositorio.alterar(console);
		
		return erros;
	}
	
	public List<String> reservar(Console console){
		List<String> erros = new ConsoleAptoParaReserva(_repositorio).validar(console);
		if(erros.isEmpty()){
			console.setStatus(StatusProduto.Reservado);
			_repositorio.atualizarStatusConsole(console);
		}
		
		return erros;
	}

	public void liberar(Console console) {
		console.setStatus(StatusProduto.Disponivel);
		_repositorio.atualizarStatusConsole(console);
	}

	public List<String> alugar(Console console) {
		List<String> erros = new ConsoleAptoParaAlugar(_repositorio).validar(console);
		if(erros.isEmpty()){
			console.setStatus(StatusProduto.Alugado);
			_repositorio.atualizarStatusConsole(console);
		}
		
		return erros;
	}
	
	public List<String> consoleAptoParaReserva(Console console){
		return new ConsoleAptoParaReserva(_repositorio).validar(console);
	}

	public void atualizarStatus(Console console) {
		_repositorio.atualizarStatusConsole(console);
	}
}
