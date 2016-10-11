package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class EquipamentoPrecisaTerTipoConsoleCadastrado implements IRegra<Equipamento> {

	private TipoConsoleServico _tipoConsoleServico;
	
	public EquipamentoPrecisaTerTipoConsoleCadastrado(TipoConsoleServico tipoConsoleServico) {
		_tipoConsoleServico = tipoConsoleServico;
	}

	@Override
	public String validar(Equipamento obj) {
		if(obj.getTipoConsole() == null)
			return "Tipo de console não informado.";
		
		TipoConsole tc = _tipoConsoleServico.buscarPorID(obj.getTipoConsole().getId());
		
		if(tc == null)
			return "Tipo de console "+ obj.getTipoConsole().getNome() +" não existe no sistema.";
		
		return null;
	}

}
