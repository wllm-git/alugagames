package alugagames.core.tiposconsole;

import java.util.List;

import alugagames.core.shared.ServicoBase;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;
import alugagames.core.tiposconsole.validacoes.TipoConsoleAptoParaAlteracao;
import alugagames.core.tiposconsole.validacoes.TipoConsoleAptoParaCadastro;
import alugagames.core.tiposconsole.validacoes.TipoConsoleAptoParaSerAtivado;
import alugagames.core.tiposconsole.validacoes.TipoConsoleAptoParaSerInativado;

public class TipoConsoleServico extends ServicoBase<TipoConsole> {

	private ITipoConsoleRepositorio _repositorio;
	
	public TipoConsoleServico(ITipoConsoleRepositorio repositorio) {
		super(repositorio);

		_repositorio = repositorio;
	}


	public List<String> adicionarTipoConsole(TipoConsole tipoConsole) {
		
		List<String> erros = new TipoConsoleAptoParaCadastro(_repositorio).validar(tipoConsole);
		if(erros.isEmpty())
			_repositorio.adicionar(tipoConsole);
		
		return erros;
	}

	public List<String> atualizarTipoConsole(TipoConsole tipoConsole) {

		List<String> erros = new TipoConsoleAptoParaAlteracao(_repositorio).validar(tipoConsole);
		if(erros.isEmpty())
			_repositorio.adicionar(tipoConsole);
		
		return erros;
	}
	
	public List<String> inativarTipoConsole(TipoConsole tipoConsole){
		
		List<String> erros = new TipoConsoleAptoParaSerInativado().validar(tipoConsole);
		if(!erros.isEmpty())
			return erros;
		
		tipoConsole.setAtivo(false);
		_repositorio.alterar(tipoConsole);
		
		return erros;
	}
	
	public List<String> ativarTipoConsole(TipoConsole tipoConsole){
		
		List<String> erros = new TipoConsoleAptoParaSerAtivado().validar(tipoConsole);
		if(!erros.isEmpty())
			return erros;
		
		tipoConsole.setAtivo(true);
		_repositorio.alterar(tipoConsole);
		
		return erros;
	}
}
