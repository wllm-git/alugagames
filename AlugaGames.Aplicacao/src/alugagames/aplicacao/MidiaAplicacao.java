package alugagames.aplicacao;

import java.util.List;
import java.util.UUID;

import alugagames.core.jogos.JogoServico;
import alugagames.core.midias.Midia;
import alugagames.core.midias.MidiaServico;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.TipoConsoleServico;
import alugagames.repositorio.JogoRepositorio;
import alugagames.repositorio.MidiaRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;

public class MidiaAplicacao extends AplicacaoBase {
	private MidiaServico _midiaServico;
	
	public MidiaAplicacao(){
		JogoServico jogoServico = new JogoServico(new JogoRepositorio());
		TipoConsoleServico tipoConsoleServico = new TipoConsoleServico(new TipoConsoleRepositorio());
		
		_midiaServico = new MidiaServico(new MidiaRepositorio(), jogoServico, tipoConsoleServico);
	}
	
	public List<String> cadastrar(Midia midia){
		
		beginTransaction();
		
		List<String> erros = _midiaServico.adicionarMidia(midia);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> atualizar(Midia midia){
		
		beginTransaction();
		
		List<String> erros = _midiaServico.atualizarMidia(midia);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> inativarMidia(Midia midia){
		beginTransaction();
		
		List<String> erros = _midiaServico.inativarMidia(midia);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> ativarMidia(Midia midia){
		beginTransaction();
		
		List<String> erros = _midiaServico.ativarMidia(midia);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public Midia buscarPorID(UUID id){
		return _midiaServico.buscarPorID(id);
	}
	
	public List<Midia> buscarTodos(){
		return _midiaServico.buscarTodos();
	}
	
	public void excluir(Midia midia){
		_midiaServico.excluir(midia);
	}
	
	public List<Midia> buscarPorTipoConsole(TipoConsole tipoConsole){
		return _midiaServico.buscarPorTipoConsole(tipoConsole);
	}
}
