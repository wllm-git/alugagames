package alugagames.core.tiposconsole.validacoes;

import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaTerNomeValido;

public class TipoConsoleAptoParaCadastro extends Validacao<TipoConsole> {

	public TipoConsoleAptoParaCadastro() {
		adicionarRegra(new TipoConsolePrecisaTerNomeValido());
	}

}
