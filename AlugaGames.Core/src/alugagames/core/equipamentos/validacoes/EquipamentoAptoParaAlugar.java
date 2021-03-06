package alugagames.core.equipamentos.validacoes;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaEstarAtivo;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaExistirNoSistema;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class EquipamentoAptoParaAlugar extends Validacao<Equipamento>{
	public EquipamentoAptoParaAlugar(IEquipamentoRepositorio repositorio) {
		adicionarRegra(new EquipamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new EquipamentoPrecisaEstarAtivo());
	}
}
