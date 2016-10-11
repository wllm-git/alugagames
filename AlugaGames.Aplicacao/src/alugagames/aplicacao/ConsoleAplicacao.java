package alugagames.aplicacao;

import java.util.List;
import java.util.UUID;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.ConsoleServico;
import alugagames.core.tiposconsole.TipoConsoleServico;
import alugagames.repositorio.ConsoleRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;

public class ConsoleAplicacao extends AplicacaoBase {
	private ConsoleServico _consoleServico;
	
	public ConsoleAplicacao(){
		TipoConsoleServico tipoConsoleServico = new TipoConsoleServico(new TipoConsoleRepositorio());
		
		_consoleServico = new ConsoleServico(new ConsoleRepositorio(), tipoConsoleServico);
	}
	
	public List<String> cadastrar(Console console){
		
		beginTransaction();
		
		List<String> erros = _consoleServico.adicionarConsole(console);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> atualizar(Console console){
		
		beginTransaction();
		
		List<String> erros = _consoleServico.atualizarConsole(console);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public Console buscarPorID(UUID id){
		return _consoleServico.buscarPorID(id);
	}
	
	public List<Console> buscarTodos(){
		return _consoleServico.buscarTodos();
	}
	
}
