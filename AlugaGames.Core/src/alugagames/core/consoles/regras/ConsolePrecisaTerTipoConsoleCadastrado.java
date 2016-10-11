package alugagames.core.consoles.regras;

import alugagames.core.consoles.Console;
import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class ConsolePrecisaTerTipoConsoleCadastrado implements IRegra<Console> {

private TipoConsoleServico _tipoConsoleServico;
	
	public ConsolePrecisaTerTipoConsoleCadastrado(TipoConsoleServico tipoConsoleServico) {
		_tipoConsoleServico = tipoConsoleServico;
	}

	@Override
	public String validar(Console obj) {
		if(obj.getTipoConsole() == null)
			return "Tipo de console não informado.";
		
		TipoConsole tc = _tipoConsoleServico.buscarPorID(obj.getTipoConsole().getId());
		
		if(tc == null)
			return "Tipo de console "+ obj.getTipoConsole().getNome() +" não existe no sistema.";
		
		return null;
	}

}
