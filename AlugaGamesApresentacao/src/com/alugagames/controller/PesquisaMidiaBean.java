package com.alugagames.controller;

import java.util.List;

import alugagames.aplicacao.MidiaAplicacao;
import alugagames.core.midias.Midia;

public class PesquisaMidiaBean {
	
	
	private MidiaAplicacao midiaAplicacao;
	private Midia midiaSelecionada;
	
	public PesquisaMidiaBean(){
		this.midiaAplicacao = new MidiaAplicacao();
		this.midiaSelecionada = new Midia();
	}
	
	
	public void excluir(){
		this.midiaAplicacao.excluir(midiaSelecionada);
	}
		

}
