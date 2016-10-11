package alugagames.aplicacao;

import java.util.List;
import java.util.UUID;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.EquipamentoServico;
import alugagames.core.tiposconsole.TipoConsoleServico;
import alugagames.repositorio.EquipamentoRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;

public class EquipamentoAplicacao extends AplicacaoBase{
	private EquipamentoServico _equipamentoServico;
	
	public EquipamentoAplicacao(){
		TipoConsoleServico tipoConsoleServico = new TipoConsoleServico(new TipoConsoleRepositorio());
		_equipamentoServico = new EquipamentoServico(new EquipamentoRepositorio(), tipoConsoleServico);
	}
	
	public List<String> cadastrar(Equipamento equipamento){
		
		beginTransaction();
		
		List<String> erros = _equipamentoServico.adicionarEquipamento(equipamento);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> atualizar(Equipamento equipamento){
		
		beginTransaction();
		
		List<String> erros = _equipamentoServico.atualizarEquipamento(equipamento);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> inativarEquipamento(Equipamento equipamento){
		beginTransaction();
		
		List<String> erros = _equipamentoServico.inativarEquipamento(equipamento);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> ativarEquipamento(Equipamento equipamento){
		beginTransaction();
		
		List<String> erros = _equipamentoServico.ativarEquipamento(equipamento);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public Equipamento buscarPorID(UUID id){
		return _equipamentoServico.buscarPorID(id);
	}
	
	public List<Equipamento> buscarTodos(){
		return _equipamentoServico.buscarTodos();
	}

}
