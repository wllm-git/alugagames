package alugagames.aplicacao;

import java.util.List;
import java.util.UUID;

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
	
	public List<String> inativarTipoConsole(TipoConsole tipoConsole){
		beginTransaction();
		
		List<String> erros = _tipoConsoleServico.inativarTipoConsole(tipoConsole);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> ativarTipoConsole(TipoConsole tipoConsole){
		beginTransaction();
		
		List<String> erros = _tipoConsoleServico.ativarTipoConsole(tipoConsole);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public TipoConsole buscarPorID(UUID id){
		return _tipoConsoleServico.buscarPorID(id);
	}
	
	public List<TipoConsole> buscarTodos(){
		return _tipoConsoleServico.buscarTodos();
	}
}
