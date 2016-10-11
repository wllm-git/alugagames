package alugagames.core.equipamentos.validacoes;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaEstarInativo;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaExistirNoSistema;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class EquipamentoAptoParaSerAtivado extends Validacao<Equipamento>{

	public EquipamentoAptoParaSerAtivado(IEquipamentoRepositorio repositorio) {
		adicionarRegra(new EquipamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new EquipamentoPrecisaEstarInativo());
	}

}
