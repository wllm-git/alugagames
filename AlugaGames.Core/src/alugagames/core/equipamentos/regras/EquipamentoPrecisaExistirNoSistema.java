package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoPrecisaExistirNoSistema implements IRegra<Equipamento> {

	private IEquipamentoRepositorio _repositorio;
	
	public EquipamentoPrecisaExistirNoSistema(IEquipamentoRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Equipamento obj) {
		Equipamento e = _repositorio.buscarPorID(obj.getId());
		
		if(e == null)
			return "Equipamento "+ obj.getNumeroSerie() +" não cadastrado no sistema.";
			
		return null;
	}

}
