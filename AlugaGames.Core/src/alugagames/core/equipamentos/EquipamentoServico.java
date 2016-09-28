package alugagames.core.equipamentos;

import java.util.Collection;
import java.util.List;

import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaAlugar;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaReserva;
import alugagames.core.shared.StatusProduto;

public class EquipamentoServico {
	private IEquipamentoRepositorio _repositorio;
	
	public EquipamentoServico(IEquipamentoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public List<String> reservar(Equipamento equipamento){
		List<String> erros = new EquipamentoAptoParaReserva(_repositorio).validar(equipamento);
		if(erros.isEmpty()){
			equipamento.setStatus(StatusProduto.Reservado);
			_repositorio.atualizarStatusEquipamento(equipamento);
		}
		
		return erros;
	}

	public void liberar(Equipamento equipamento) {
		equipamento.setStatus(StatusProduto.Disponivel);
		_repositorio.atualizarStatusEquipamento(equipamento);
	}

	public Collection<String> alugar(Equipamento equipamento) {
		List<String> erros = new EquipamentoAptoParaAlugar(_repositorio).validar(equipamento);
		if(erros.isEmpty()){
			equipamento.setStatus(StatusProduto.Alugado);
			_repositorio.atualizarStatusEquipamento(equipamento);
		}
		
		return erros;
	}
}
