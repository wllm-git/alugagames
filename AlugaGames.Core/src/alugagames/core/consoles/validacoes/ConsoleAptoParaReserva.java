package alugagames.core.consoles.validacoes;

import alugagames.core.consoles.Console;
import alugagames.core.consoles.regras.ConsolePrecisaEstarAtivo;
import alugagames.core.consoles.regras.ConsolePrecisaEstarDisponivel;
import alugagames.core.consoles.regras.ConsolePrecisaExistir;
import alugagames.core.consoles.repositorio.IConsoleRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class ConsoleAptoParaReserva extends Validacao<Console>{
	public ConsoleAptoParaReserva(IConsoleRepositorio repositorio){
		adicionarRegra(new ConsolePrecisaExistir(repositorio));
		adicionarRegra(new ConsolePrecisaEstarAtivo(repositorio));
		adicionarRegra(new ConsolePrecisaEstarDisponivel(repositorio));
	}
}
