package alugagames.core.equipamentos.validacoes;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaEstarAtivo;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaExistirNoSistema;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerNumeroSerieUnicoAlt;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerNumeroSerieValido;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerPrecoValido;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerTipoConsoleCadastrado;
import alugagames.core.equipamentos.regras.EquipamentoPrecisaTerTipoValido;
import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class EquipamentoAptoParaAlteracao extends Validacao<Equipamento>{
	public EquipamentoAptoParaAlteracao(IEquipamentoRepositorio repositorio, TipoConsoleServico tipoConsoleServico){
		adicionarRegra(new EquipamentoPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new EquipamentoPrecisaTerNumeroSerieValido());
		adicionarRegra(new EquipamentoPrecisaTerNumeroSerieUnicoAlt(repositorio));
		adicionarRegra(new EquipamentoPrecisaTerTipoValido());
		adicionarRegra(new EquipamentoPrecisaTerPrecoValido());
		adicionarRegra(new EquipamentoPrecisaTerTipoConsoleCadastrado(tipoConsoleServico));
		adicionarRegra(new EquipamentoPrecisaEstarAtivo());
	}
}
