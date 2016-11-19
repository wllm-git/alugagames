package alugagames.core.equipamentos;

import java.util.List;

import alugagames.core.equipamentos.repositorio.IEquipamentoRepositorio;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaAlteracao;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaAlugar;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaCadastro;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaReserva;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaSerAtivado;
import alugagames.core.equipamentos.validacoes.EquipamentoAptoParaSerInativado;
import alugagames.core.shared.ServicoBase;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.Voltagem;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class EquipamentoServico extends ServicoBase<Equipamento>{
	private IEquipamentoRepositorio _repositorio;
	private TipoConsoleServico _tipoConsoleServico;
	
	public EquipamentoServico(IEquipamentoRepositorio repositorio){
		super(repositorio);
		_repositorio = repositorio;
	}
	
	public EquipamentoServico(IEquipamentoRepositorio repositorio, TipoConsoleServico tipoConsoleServico){
		super(repositorio);
		_repositorio = repositorio;
		_tipoConsoleServico = tipoConsoleServico;
	}
	
	public List<String> adicionarEquipamento(Equipamento equipamento){
		List<String> erros = new EquipamentoAptoParaCadastro(_repositorio, _tipoConsoleServico).validar(equipamento);
		if(!erros.isEmpty())
			return erros;
		
		if(equipamento.getVoltagem() == null)
			equipamento.setVoltagem(Voltagem.V_UNI);
		
		equipamento.setStatus(StatusProduto.Disponivel);
		equipamento.setAtivo(true);
		
		
		_repositorio.adicionar(equipamento);
		
		return erros;
	}
	
	public List<String> atualizarEquipamento(Equipamento equipamento){
		List<String> erros = new EquipamentoAptoParaAlteracao(_repositorio, _tipoConsoleServico).validar(equipamento);
		if(!erros.isEmpty())
			return erros;
		
		if(equipamento.getVoltagem() == null)
			equipamento.setVoltagem(Voltagem.V_UNI);
		
		_repositorio.adicionar(equipamento);
		
		return erros;
	}
	
	public List<String> inativarEquipamento(Equipamento equipamento) {
		List<String> erros = new EquipamentoAptoParaSerInativado(_repositorio).validar(equipamento);
		if(!erros.isEmpty())
			return erros;
		
		equipamento.setAtivo(false);
		_repositorio.adicionar(equipamento);
		
		return erros;
	}

	public List<String> ativarEquipamento(Equipamento equipamento) {
		List<String> erros = new EquipamentoAptoParaSerAtivado(_repositorio).validar(equipamento);
		if(!erros.isEmpty())
			return erros;
		
		equipamento.setAtivo(true);
		_repositorio.adicionar(equipamento);
		
		return erros;
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

	public List<String> alugar(Equipamento equipamento) {
		List<String> erros = new EquipamentoAptoParaAlugar(_repositorio).validar(equipamento);
		if(erros.isEmpty()){
			equipamento.setStatus(StatusProduto.Alugado);
			_repositorio.atualizarStatusEquipamento(equipamento);
		}
		
		return erros;
	}

	public List<String> equipamentoAptoParaReserva(Equipamento equipamento) {
		return new EquipamentoAptoParaReserva(_repositorio).validar(equipamento);
	}

	public void atualizarStatus(Equipamento equipamento) {
		_repositorio.atualizarStatusEquipamento(equipamento);
	}
}
