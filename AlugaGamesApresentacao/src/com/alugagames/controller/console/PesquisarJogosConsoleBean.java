package com.alugagames.controller.console;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.filter.JogoFilter;

import alugagames.aplicacao.JogoAplicacao;
import alugagames.core.jogos.Jogo;

@ManagedBean
@ViewScoped
public class PesquisarJogosConsoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogo jogoSelecionado;
	private List<Jogo> jogosFiltrados;
	private JogoFilter filtro;
	private boolean isPesquisa;

	public PesquisarJogosConsoleBean() {
		this.isPesquisa = false;
	}

	public void inicializar() {
		this.jogoSelecionado = new Jogo();

		if (!this.isPesquisa)
			this.jogosFiltrados = new JogoAplicacao().buscarTodos();

		this.filtro = new JogoFilter();

	}



	public void pesquisar() {

		this.jogosFiltrados.clear();

		if (!"".equals(this.filtro.getNome())) {

			this.jogosFiltrados = new JogoAplicacao().pesquisaPorNome(this.filtro.getNome());
		}

		else {
			inicializar();
			this.isPesquisa = false;
			return;
		}

		this.isPesquisa = true;

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

	public JogoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(JogoFilter filtro) {
		this.filtro = filtro;
	}

}
