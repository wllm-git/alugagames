package alugagames.core.equipamentos.validacoes;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.regras.EquipamentoNaoPodeEstarAlugado;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaEstarAtivo;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaExistirNoSistema;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class EquipamentoAptoParaSerInativado extends Validacao<Equipamento>{
	public EquipamentoAptoParaSerInativado(IEquipamentoRepositorio repositorio){
		adicionarRegra(new EquipamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new EquipamentoNaoPodeEstarAlugado());
		adicionarRegra(new EquipamentoPrecisaEstarAtivo());
	}
}
