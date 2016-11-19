package com.alugagames.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import alugagames.aplicacao.JogoAplicacao;
import alugagames.core.jogos.Jogo;

@ManagedBean
@ViewScoped
public class PesquisarJogosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Jogo jogoSelecionado;
	private List<Jogo> jogosFiltrados;
	
	public PesquisarJogosBean(){
		
	}
	
	public void inicializar(){
		this.jogoSelecionado = new Jogo();
		this.jogosFiltrados = new JogoAplicacao().buscarTodos();
	}
	
	public void excluir(){
		new JogoAplicacao().excluir(this.jogoSelecionado);
	}
	
	public Jogo getJogoSelecionado() {
		return jogoSelecionado;
	}
	public void setJogoSelecionado(Jogo jogoSelecionado) {
		this.jogoSelecionado = jogoSelecionado;
	}
	public List<Jogo> getJogosFiltrados() {
		return jogosFiltrados;
	}
	
	
	

}
