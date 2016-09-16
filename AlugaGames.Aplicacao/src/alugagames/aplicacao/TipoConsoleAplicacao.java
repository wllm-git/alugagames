package alugagames.aplicacao;

import java.util.List;

import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.TipoConsoleServico;
import alugagames.repositorio.TipoConsoleRepositorio;

public class TipoConsoleAplicacao extends AplicacaoBase{
	private TipoConsoleServico _tipoConsoleServico;
	
	public TipoConsoleAplicacao(){
		_tipoConsoleServico = new TipoConsoleServico(new TipoConsoleRepositorio());
	}
	
	public List<String> cadastrar(TipoConsole tipoConsole){
		
		beginTransaction();
		
		List<String> erros = _tipoConsoleServico.adicionarTipoConsole(tipoConsole);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> atualizar(TipoConsole tipoConsole){
		
		beginTransaction();
		
		List<String> erros = _tipoConsoleServico.atualizarTipoConsole(tipoConsole);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public void excluir(TipoConsole tipoConsole){
		_tipoConsoleServico.excluir(tipoConsole);
	}
	
	public List<TipoConsole> buscarTodos(){
		return _tipoConsoleServico.buscarTodos();
	}
}
