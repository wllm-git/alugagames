package com.alugagames.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.EquipamentoAplicacao;
import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.TipoEquipamento;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.Voltagem;
import alugagames.core.tiposconsole.TipoConsole;

@ManagedBean
@ViewScoped
public class EquipamentoBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Equipamento equipamento;
	private EquipamentoAplicacao equipamentoAplicacao;
	private List<TipoEquipamento> tiposEquipamento;
	private List<Voltagem> voltagens;
	private List<TipoConsole> consoles;
	private List<StatusProduto> status;
	
	public EquipamentoBean(){
		
		this.equipamento = new Equipamento();
		this.equipamentoAplicacao = new EquipamentoAplicacao();
		this.tiposEquipamento = new ArrayList<>();
		this.voltagens = new ArrayList<>();
		this.consoles = new ArrayList<>();
		this.status = new ArrayList<>();
		
		getTodosTiposEquipamento();
		getTodasVoltagens();
		getTodosConsoles();
		getTodosStatus();
	}
	
	
	public void salvarEquipamento(){
		List<String> retorno = this.equipamentoAplicacao.cadastrar(this.equipamento);
		
		if(!retorno.isEmpty()){
			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
				return;
			}
		}
		
		FacesUtil.addInfoMessage("Equipamento cadastrado com sucesso");
		
		this.equipamento = new Equipamento();
	}
	
	private void getTodosConsoles() {
		
		
			this.consoles = new TipoConsoleAplicacao().buscarTodos();
		
		
	}
	
	private void getTodosStatus(){
		
		for (StatusProduto status : StatusProduto.values()) {
			this.status.add(status);
		}
	}

	private void getTodosTiposEquipamento(){
		
		for (TipoEquipamento tipoEquipamento : TipoEquipamento.values()) {
			this.tiposEquipamento.add(tipoEquipamento);	
		}
		
	}
	
	private void getTodasVoltagens(){
		
		for (Voltagem voltagem : Voltagem.values()) {
			this.voltagens.add(voltagem);
		}
	}
	
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public List<TipoEquipamento> getTiposEquipamento() {
		return tiposEquipamento;
	}

	public List<Voltagem> getVoltagens() {
		return voltagens;
	}

	public List<TipoConsole> getConsoles() {
		return consoles;
	}

	public List<StatusProduto> getStatus() {
		return status;
	}
	
	
	
	
	
}
