package alugagames.core.equipamentos.regras;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.validacoesregras.IRegra;

public class EquipamentoPrecisaEstarDisponivel implements IRegra<Equipamento> {
	private IEquipamentoRepositorio _repositorio;
	
	public EquipamentoPrecisaEstarDisponivel(IEquipamentoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Equipamento obj) {
		Equipamento e = _repositorio.buscarPorID(obj.getId());
		if(e == null)
			return "equipamento "+ obj.getNumeroSerie() +" não está cadastrado no sistema.";
		else if(!e.getStatus().equals(StatusProduto.Disponivel))
			return "equipamento "+ e.getNumeroSerie() +" não está disponível.";
		
		return null;
	}

}
