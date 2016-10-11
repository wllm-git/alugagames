package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class MidiaPrecisaTerTipoConsoleCadastrado implements IRegra<Midia> {

	private TipoConsoleServico _tipoConsoleServico;
	
	public MidiaPrecisaTerTipoConsoleCadastrado(TipoConsoleServico tipoConsoleServico) {
		_tipoConsoleServico = tipoConsoleServico;
	}

	@Override
	public String validar(Midia obj) {
		if(obj.getTipoConsole() == null)
			return "Tipo de console não informado.";
		
		TipoConsole tc = _tipoConsoleServico.buscarPorID(obj.getTipoConsole().getId());
		
		if(tc == null)
			return "Tipo de console "+ obj.getTipoConsole().getNome() +" não existe no sistema.";
		
		return null;
	}

}
