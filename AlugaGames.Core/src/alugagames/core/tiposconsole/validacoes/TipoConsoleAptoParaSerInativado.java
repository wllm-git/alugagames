package alugagames.core.tiposconsole.validacoes;

import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaEstarAtivo;

public class TipoConsoleAptoParaSerInativado extends Validacao<TipoConsole>{
	public TipoConsoleAptoParaSerInativado(){
		adicionarRegra(new TipoConsolePrecisaEstarAtivo());
	}
}
