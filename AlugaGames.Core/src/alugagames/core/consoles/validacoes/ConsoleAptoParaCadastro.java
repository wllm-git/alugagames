package alugagames.core.consoles.validacoes;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.regras.ConsolePrecisaNumeroSerieValido;
import alugagames.core.consoles.regras.ConsolePrecisaTerPrecoMaiorQueZero;
import alugagames.core.shared.validacoesregras.Validacao;

public class ConsoleAptoParaCadastro extends Validacao<Console> {
	public ConsoleAptoParaCadastro(){
		adicionarRegra(new ConsolePrecisaNumeroSerieValido());
		adicionarRegra(new ConsolePrecisaTerPrecoMaiorQueZero());
	}
}
