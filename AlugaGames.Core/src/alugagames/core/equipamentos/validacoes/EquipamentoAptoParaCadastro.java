package alugagames.core.equipamentos.validacoes;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerNumeroSerieUnico;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerNumeroSerieValido;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerPrecoValido;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerTipoConsoleCadastrado;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerTipoValido;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class EquipamentoAptoParaCadastro extends Validacao<Equipamento>{
	public EquipamentoAptoParaCadastro(IEquipamentoRepositorio repositorio, TipoConsoleServico tipoConsoleServico){
		adicionarRegra(new EquipamentoPrecisaTerNumeroSerieValido());
		adicionarRegra(new EquipamentoPrecisaTerNumeroSerieUnico(repositorio));
		adicionarRegra(new EquipamentoPrecisaTerTipoValido());
		adicionarRegra(new EquipamentoPrecisaTerPrecoValido());
		adicionarRegra(new EquipamentoPrecisaTerTipoConsoleCadastrado(tipoConsoleServico));
	}
}
