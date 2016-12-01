package com.alugagames.controller.aluguel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;

@ManagedBean
@ViewScoped
public class AluguelCheckOutBean {
	private Aluguel aluguel;
	private AluguelAplicacao aluguelAplicacao;
	
	
	
	
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
