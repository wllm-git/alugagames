package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoPrecisaTerNumeroSerieUnico implements IRegra<Equipamento> {

	private IEquipamentoRepositorio _repositorio;
	
	public EquipamentoPrecisaTerNumeroSerieUnico(IEquipamentoRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Equipamento obj) {
		Equipamento e = _repositorio.buscarPorNumeroSerie(obj.getNumeroSerie());
		
		if(e != null)
			return "Número de série " + obj.getNumeroSerie() + " já está em uso.";
		
		return null;
	}

}
