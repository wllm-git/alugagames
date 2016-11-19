package com.alugagames.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.JogoAplicacao;
import alugagames.aplicacao.MidiaAplicacao;
import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.jogos.Categoria;
import alugagames.core.jogos.Jogo;
import alugagames.core.midias.Midia;
import alugagames.core.shared.StatusProduto;
import alugagames.core.tiposconsole.TipoConsole;

@ManagedBean
@ViewScoped
public class JogoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Categoria> categorias;
	private JogoAplicacao jogoAplicacao;
	private Jogo jogo;
	private Midia midia;
	private Midia midiaSelecionada;
	private boolean novoJogo;
	private List<TipoConsole> consoles;

	public JogoBean() {
		
		
		limparFormularios();
		getTodasCategorias();
		getTodosConsoles();
		 novoJogo = isNovo();
	

	}
	
	
	public void verifyMidia(){
		
		if(this.midia.getNumeroSerie() != null){
			this.jogo = new JogoAplicacao().buscarPorID(this.midia.getJogo().getId());
			novoJogo = isNovo();
		}
	}
	

	public void limparFormularios() {

		this.jogo = new Jogo();
		this.jogoAplicacao = new JogoAplicacao();
		this.midia = new Midia();
		this.midiaSelecionada = new Midia();
		novoJogo = isNovo();
	}

	public void salvarJogo() {

		List<String> retorno = jogoAplicacao.cadastrar(jogo);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Jogo cadastrado com sucesso!");

		
		novoJogo = isNovo();

	}

	public void salvarMidia() {
		
		this.midia.setJogo(jogo);
		this.midia.setStatus(StatusProduto.Disponivel);
		
		List<String> retorno = new MidiaAplicacao().cadastrar(this.midia);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}
			return;
		}

		this.jogo.getMidias().add(this.midia);
		this.jogoAplicacao.atualizar(jogo);

		FacesUtil.addInfoMessage("Jogo cadastrado com sucesso!");
		
		this.midia = new Midia();

	}
	
	public void excluirMidia(){
		new MidiaAplicacao().excluir(this.midiaSelecionada);
		FacesUtil.addInfoMessage("Midia Excluida com sucesso!");
	}

	public boolean isNovo() {
		return this.jogo.getNome() == null ? true : false;
	}

	private List<Categoria> getTodasCategorias() {

		categorias = new ArrayList<>();

		for (Categoria categoria : Categoria.values()) {
			categorias.add(categoria);
		}

		return categorias;
	}

	private List<TipoConsole> getTodosConsoles() {
		consoles = new TipoConsoleAplicacao().buscarTodos();

		return consoles;
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

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	public boolean isNovoJogo() {
		return novoJogo;
	}

	public List<TipoConsole> getConsoles() {
		return consoles;
	}

	public Midia getMidiaSelecionada() {
		return midiaSelecionada;
	}

	public void setMidiaSelecionada(Midia midiaSelecionada) {
		this.midiaSelecionada = midiaSelecionada;
	}

	
}
