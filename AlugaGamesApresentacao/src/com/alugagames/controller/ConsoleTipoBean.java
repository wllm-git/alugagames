package com.alugagames.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.tiposconsole.TipoConsole;

@ManagedBean
@ViewScoped
public class ConsoleTipoBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private TipoConsole tipoConsole;
	private TipoConsoleAplicacao tipoConsoleAplicacao;
	
	
	public ConsoleTipoBean() {
		this.tipoConsole = new TipoConsole();
		this.tipoConsoleAplicacao = new TipoConsoleAplicacao();
	}
	
	
	public void salvarTipoConsole() {

		

		List<String> retorno = tipoConsoleAplicacao.cadastrar(this.tipoConsole);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Tipo de Console cadastrado com sucesso!");
		
		tipoConsole = new TipoConsole();

	}
	


	public TipoConsole getTipoConsole() {
		return tipoConsole;
	}


	public void setTipoConsole(TipoConsole tipoConsole) {
		this.tipoConsole = tipoConsole;
	}
	
	

}
