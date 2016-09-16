package alugagames.aplicacao;

import java.util.List;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.JogoServico;
import alugagames.repositorio.JogoRepositorio;

public class JogoAplicacao extends AplicacaoBase{
	private JogoServico _jogoServico;
	
	public JogoAplicacao(){
		_jogoServico = new JogoServico(new JogoRepositorio());
	}
	
	public List<String> cadastrar(Jogo console){
		
		beginTransaction();
		
		List<String> erros = _jogoServico.adicionarJogo(console);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> atualizar(Jogo console){
		
		beginTransaction();
		
		List<String> erros = _jogoServico.atualizarJogo(console);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public void excluir(Jogo jogo){
		_jogoServico.excluir(jogo);
	}
	
	public List<Jogo> buscarTodos(){
		return _jogoServico.buscarTodos();
	}
}
