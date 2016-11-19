package alugagames.core.consoles.validacoes;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.regras.ConsolePrecisaTerNumeroSerieUnico;
import alugagames.core.consoles.regras.ConsolePrecisaTerNumeroSerieValido;
import alugagames.core.consoles.regras.ConsolePrecisaTerPrecoMaiorQueZero;
import alugagames.core.consoles.regras.ConsolePrecisaTerTipoConsoleCadastrado;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class ConsoleAptoParaCadastro extends Validacao<Console> {
	public ConsoleAptoParaCadastro(IConsoleRepositorio repositorio, TipoConsoleServico tipoConsoleServico){
		adicionarRegra(new ConsolePrecisaTerNumeroSerieValido());
		adicionarRegra(new ConsolePrecisaTerNumeroSerieUnico(repositorio));
		adicionarRegra(new ConsolePrecisaTerPrecoMaiorQueZero());
		adicionarRegra(new ConsolePrecisaTerTipoConsoleCadastrado(tipoConsoleServico));
	}
}
