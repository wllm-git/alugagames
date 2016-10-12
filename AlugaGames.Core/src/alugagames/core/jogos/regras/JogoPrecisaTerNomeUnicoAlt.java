package alugagames.core.jogos.regras;

import alugagames.core.jogos.Jogo;
import alugagames.core.jogos.repositorio.IJogoRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class JogoPrecisaTerNomeUnicoAlt implements IRegra<Jogo> {

private IJogoRepositorio _repositorio;
	
	public JogoPrecisaTerNomeUnicoAlt(IJogoRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Jogo obj) {
		Jogo j = _repositorio.buscarPorNome(obj.getNome());
		
		if(j != null && !j.getId().equals(obj.getId()))
			return "Nome já está em uso.";
		
		return null;
	}

}
