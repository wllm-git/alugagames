package alugagames.aplicacao;

import java.util.List;

import alugagames.core.midias.Midia;
import alugagames.core.midias.MidiaServico;
import alugagames.repositorio.MidiaRepositorio;

public class MidiaAplicacao extends AplicacaoBase {
private MidiaServico _midiaServico;
	
	public MidiaAplicacao(){
		_midiaServico = new MidiaServico(new MidiaRepositorio());
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
		
	public List<Midia> buscarTodos(){
		return _midiaServico.buscarTodos();
	}
}
