package alugagames.core.equipamentos.repositorio;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IEquipamentoRepositorio extends IRepositorioBase<Equipamento>{

	public void atualizarStatusEquipamento(Equipamento equipamento);

	public Equipamento buscarPorNumeroSerie(String numeroSerie);

}
