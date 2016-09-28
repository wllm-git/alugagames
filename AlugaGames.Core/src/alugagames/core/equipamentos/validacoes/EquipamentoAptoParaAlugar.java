package alugagames.core.equipamentos.validacoes;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class EquipamentoAptoParaAlugar extends Validacao<Equipamento>{
	public EquipamentoAptoParaAlugar(IEquipamentoRepositorio repositorio) {
		//TODO adicionarRegra(new EquipamentoPrecisaExistir(repositorio));
		//TODO adicionarRegra(new EquipamentoPrecisaEstarAtivo(repositorio));
	}
}
