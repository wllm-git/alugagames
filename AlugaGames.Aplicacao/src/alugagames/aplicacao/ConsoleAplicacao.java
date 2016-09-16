package alugagames.aplicacao;

import java.util.List;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.ConsoleServico;
import alugagames.repositorio.ConsoleRepositorio;

public class ConsoleAplicacao extends AplicacaoBase {
	private ConsoleServico _consoleServico;
	
	public ConsoleAplicacao(){
		_consoleServico = new ConsoleServico(new ConsoleRepositorio());
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
	
	public void excluir(Console console){
		_consoleServico.excluir(console);
	}
	
	public List<Console> buscarTodos(){
		return _consoleServico.buscarTodos();
	}
	
}
