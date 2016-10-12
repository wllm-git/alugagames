package alugagames.core.tiposconsole.validacoes;

import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaEstarInativo;

public class TipoConsoleAptoParaSerAtivado extends Validacao<TipoConsole>{
	public TipoConsoleAptoParaSerAtivado(){
		adicionarRegra(new TipoConsolePrecisaEstarInativo());
	}
}
