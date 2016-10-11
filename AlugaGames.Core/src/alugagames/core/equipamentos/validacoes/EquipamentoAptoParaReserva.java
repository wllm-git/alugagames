package alugagames.core.equipamentos.validacoes;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaEstarAtivo;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaEstarDisponivel;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaExistirNoSistema;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class EquipamentoAptoParaReserva extends Validacao<Equipamento>{
	public EquipamentoAptoParaReserva(IEquipamentoRepositorio repositorio){
		adicionarRegra(new EquipamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new EquipamentoPrecisaEstarAtivo());
		adicionarRegra(new EquipamentoPrecisaEstarDisponivel(repositorio));
	}
}
