package alugagames.core.tiposconsole.validacoes;

import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaTerNomeUnico;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaTerNomeValido;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;

public class TipoConsoleAptoParaCadastro extends Validacao<TipoConsole> {

	public TipoConsoleAptoParaCadastro(ITipoConsoleRepositorio repositorio) {
		adicionarRegra(new TipoConsolePrecisaTerNomeValido());
		adicionarRegra(new TipoConsolePrecisaTerNomeUnico(repositorio));
	}

}
