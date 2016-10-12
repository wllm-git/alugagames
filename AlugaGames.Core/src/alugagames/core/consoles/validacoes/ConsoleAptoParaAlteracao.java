package alugagames.core.consoles.validacoes;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.regras.ConsolePrecisaEstarAtivo;
import alugagames.core.consoles.regras.ConsolePrecisaTerNumeroSerieUnicoAtl;
import alugagames.core.consoles.regras.ConsolePrecisaTerNumeroSerieValido;
import alugagames.core.consoles.regras.ConsolePrecisaTerPrecoMaiorQueZero;
import alugagames.core.consoles.regras.ConsolePrecisaTerTipoConsoleCadastrado;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class ConsoleAptoParaAlteracao extends Validacao<Console> {
	public ConsoleAptoParaAlteracao(IConsoleRepositorio repositorio, TipoConsoleServico tipoConsoleServico){
		adicionarRegra(new ConsolePrecisaTerNumeroSerieValido());
		adicionarRegra(new ConsolePrecisaTerNumeroSerieUnicoAtl(repositorio));
		adicionarRegra(new ConsolePrecisaTerPrecoMaiorQueZero());
		adicionarRegra(new ConsolePrecisaTerTipoConsoleCadastrado(tipoConsoleServico));
		adicionarRegra(new ConsolePrecisaEstarAtivo(repositorio));
	}
}
