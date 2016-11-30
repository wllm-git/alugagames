package com.alugagames.controller.console;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.filter.ConsoleFilter;
import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.ConsoleAplicacao;
import alugagames.core.consoles.Console;

@ManagedBean
@ViewScoped
public class PesquisarConsoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Console consoleSelecionado;
	private List<Console> consolesFiltrados;
	private ConsoleFilter filtro;
	private boolean isPesquisa;

	public PesquisarConsoleBean() {
		this.isPesquisa = false;
		
	}

	public void inicializar() {
		this.consoleSelecionado = new Console();

		if (!this.isPesquisa)
			this.consolesFiltrados = new ConsoleAplicacao().buscarTodos();

		this.filtro = new  ConsoleFilter();

	}



	public void pesquisar() {

		this.consolesFiltrados.clear();

		if (!"".equals(this.filtro.getNumeroSerie())) {
			
			
			Console consolePesquisa = new ConsoleAplicacao().buscarPorNumeroSerie(filtro.getNumeroSerie());
			if(consolePesquisa != null){
				this.consolesFiltrados.clear();
				this.consolesFiltrados.add(consolePesquisa);
				this.isPesquisa = false;
				return;
			}
			
			
		}

		else {
			inicializar();
			this.isPesquisa = false;
			return;
		}

		this.isPesquisa = true;

	}
	
	public void excluirConsole() {
		
		
		new ConsoleAplicacao().excluir(this.consoleSelecionado);


		inicializar();

		FacesUtil.addInfoMessage("Console excluído com sucesso!");
	}

	public Console getConsoleSelecionado() {
		return consoleSelecionado;
	}

	public void setConsoleSelecionado(Console consoleSelecionado) {
		this.consoleSelecionado = consoleSelecionado;
	}

	

	public ConsoleFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ConsoleFilter filtro) {
		this.filtro = filtro;
	}

	public List<Console> getConsolesFiltrados() {
		return consolesFiltrados;
	}
	
	

}
