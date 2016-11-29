package com.alugagames.controller.console;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.ConsoleAplicacao;
import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.consoles.Console;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.Voltagem;
import alugagames.core.tiposconsole.TipoConsole;

@ManagedBean
@ViewScoped
public class ConsoleBean implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Console console;
	private ConsoleAplicacao consoleAplicacao;
	private List<Voltagem> voltagens;
	private List<TipoConsole> consoles;
	private List<StatusProduto> status;
	
	public ConsoleBean(){
		
		this.console = new Console();
		this.consoleAplicacao = new ConsoleAplicacao();
		this.voltagens = new ArrayList<>();
		this.consoles = new ArrayList<>();
		this.status = new ArrayList<>();
		
		getTodasVoltagens();
		getTodosConsoles();
		getTodosStatus();
	}
	
	
	public void salvarConsole(){
		List<String> retorno = this.consoleAplicacao.cadastrar(this.console);
		
		if(!retorno.isEmpty()){
			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
				return;
			}
		}
		
		FacesUtil.addInfoMessage("Console cadastrado com sucesso");
		
		this.console = new Console();
	}
	
	private void getTodosConsoles() {
		
		
			this.consoles = new TipoConsoleAplicacao().buscarTodos();
		
		
	}
	
	private void getTodosStatus(){
		
		for (StatusProduto status : StatusProduto.values()) {
			this.status.add(status);
		}
	}


		
	
	
	private void getTodasVoltagens(){
		
		for (Voltagem voltagem : Voltagem.values()) {
			this.voltagens.add(voltagem);
		}
	}
	
	
	public Console getEquipamento() {
		return console;
	}
	public void setEquipamento(Console equipamento) {
		this.console = equipamento;
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


	public Console getConsole() {
		return console;
	}


	public void setConsole(Console console) {
		this.console = console;
	}
	
	
	
	
	
}
