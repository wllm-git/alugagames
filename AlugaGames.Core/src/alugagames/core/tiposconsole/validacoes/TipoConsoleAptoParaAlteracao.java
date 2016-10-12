package alugagames.core.tiposconsole.validacoes;

import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaEstarAtivo;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaTerNomeUnicoAlt;
import alugagames.core.tiposconsole.regras.TipoConsolePrecisaTerNomeValido;
import alugagames.core.tiposconsole.repositorio.ITipoConsoleRepositorio;

public class TipoConsoleAptoParaAlteracao extends Validacao<TipoConsole> {

	public TipoConsoleAptoParaAlteracao(ITipoConsoleRepositorio repositorio) {
		adicionarRegra(new TipoConsolePrecisaTerNomeValido());
		adicionarRegra(new TipoConsolePrecisaTerNomeUnicoAlt(repositorio));
		adicionarRegra(new TipoConsolePrecisaEstarAtivo());
	}
}
