package alugagames.aplicacao;

import java.util.List;
import java.util.UUID;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.JogoServico;
import alugagames.core.midias.Midia;
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
	
	public Jogo buscarPorID(UUID id){
		return _jogoServico.buscarPorID(id);
	}
	
	public List<Jogo> buscarTodos(){
		return _jogoServico.buscarTodos();
	}
	
	public void excluir(Jogo jogo){
		
		for (Midia midia : jogo.getMidias()) {
			new MidiaAplicacao().excluir(midia);
		}
		
		_jogoServico.excluir(jogo);
	}
}
