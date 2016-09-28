package alugagames.core.jogos;

import java.util.List;

import alugagames.core.jogos.repositorio.IJogoRepositorio;
import alugagames.core.jogos.validacoes.JogoAptoParaCadastro;
import alugagames.core.shared.ServicoBase;

public class JogoServico extends ServicoBase<Jogo> {

	private IJogoRepositorio _repositorio;
	
	public JogoServico(IJogoRepositorio repositorio) {
		super(repositorio);
		
		_repositorio = repositorio;
	}

	public List<String> adicionarJogo(Jogo jogo) {
		
		List<String> erros = new JogoAptoParaCadastro().validar(jogo);
		if(erros.isEmpty())
			_repositorio.adicionar(jogo);
		
		return erros;
	}

	public List<String> atualizarJogo(Jogo jogo) {
		
		List<String> erros = new JogoAptoParaCadastro().validar(jogo);
		if(erros.isEmpty())
			_repositorio.adicionar(jogo);
		
		return erros;
	}

}
