package com.alugagames.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import alugagames.aplicacao.JogoAplicacao;
import alugagames.core.jogos.Categoria;
import alugagames.core.jogos.Jogo;

@ManagedBean
@ViewScoped
public class JogoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Categoria> categorias;
	public JogoAplicacao jogoAplicacao;
	public Jogo jogo;

	public JogoBean() {
		jogo = new Jogo();
		jogoAplicacao = new JogoAplicacao();
		getTodasCategorias();
	}

	private List<Categoria> getTodasCategorias() {

		categorias = new ArrayList<>();

		for (Categoria categoria : Categoria.values()) {
			categorias.add(categoria);
		}

		return categorias;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
