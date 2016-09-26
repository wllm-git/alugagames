package alugagames.core.consoles.validacoes;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.regras.ConsolePrecisaTerNumeroSerieValido;
import alugagames.core.consoles.regras.ConsolePrecisaTerPrecoMaiorQueZero;
import alugagames.core.shared.validacoesregras.Validacao;

public class ConsoleAptoParaAlteracao extends Validacao<Console> {
	public ConsoleAptoParaAlteracao(){
		adicionarRegra(new ConsolePrecisaTerNumeroSerieValido());
		adicionarRegra(new ConsolePrecisaTerPrecoMaiorQueZero());
	}
}
