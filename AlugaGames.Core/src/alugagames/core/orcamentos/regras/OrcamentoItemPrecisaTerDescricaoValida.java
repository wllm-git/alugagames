package alugagames.core.orcamentos.regras;

import java.util.List;

import alugagames.core.equipamentos.TipoEquipamento;
import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.shared.validacoesregras.IRegra;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class OrcamentoItemPrecisaTerDescricaoValida implements
		IRegra<OrcamentoItem> {

	private TipoConsoleServico _tipoConsoleServico;	
	
	public OrcamentoItemPrecisaTerDescricaoValida(TipoConsoleServico tipoConsoleServico) {
		_tipoConsoleServico = tipoConsoleServico;
	}

	@Override
	public String validar(OrcamentoItem obj) {
		if(obj.getDescricao() == null || obj.getDescricao().isEmpty())
			return "Descrição não informada.";
		
		for (TipoEquipamento tipoEquip : TipoEquipamento.values()) {
			if(tipoEquip.toString().equals(obj.getDescricao()))
				return null;
		}
		
		List<TipoConsole> tiposConsole = _tipoConsoleServico.buscarTodos();
		for (TipoConsole tipoConsole : tiposConsole) {
			if(tipoConsole.getNome().equals(obj.getDescricao()))
				return null;
		}
		
		return "Descrição "+ obj.getDescricao() +" inválida.";
	}

}
