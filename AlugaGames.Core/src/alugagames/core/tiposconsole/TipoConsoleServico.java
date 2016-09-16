package alugagames.core.tiposconsole;

import java.util.List;

import alugagames.core.shared.ServicoBase;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;
import alugagames.core.tiposconsole.validacoes.TipoConsoleAptoParaCadastro;

public class TipoConsoleServico extends ServicoBase<TipoConsole> {

	private ITipoConsoleRepositorio _repositorio;
	
	public TipoConsoleServico(ITipoConsoleRepositorio repositorio) {
		super(repositorio);

		_repositorio = repositorio;
	}


	public List<String> adicionarTipoConsole(TipoConsole tipoConsole) {
		
		List<String> erros = new TipoConsoleAptoParaCadastro().validar(tipoConsole);
		if(erros.isEmpty())
			super.adicionar(tipoConsole);
		
		return erros;
	}

	public List<String> atualizarTipoConsole(TipoConsole tipoConsole) {

		List<String> erros = new TipoConsoleAptoParaCadastro().validar(tipoConsole);
		if(erros.isEmpty())
			super.adicionar(tipoConsole);
		
		return erros;
	}
}
