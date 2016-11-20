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
	private MidiaAplicacao midiaAplicacao;
	private Jogo jogo;
	private Midia midia;
	private Midia midiaSelecionada;
	private boolean novoJogo;
	private List<TipoConsole> consoles;
	private boolean editando;

	public JogoBean() {
		
		
		limparFormularios();
		getTodasCategorias();
		getTodosConsoles();
		 novoJogo = isNovo();
	

	}
	
	
	public void verifyMidia(){
		
		this.editando = true;
		
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
		this.midiaAplicacao = new MidiaAplicacao();
		novoJogo = isNovo();
	}

	public void salvarJogo() {
		
		List<String> retorno;
		
		if(!editando){
			 retorno = jogoAplicacao.cadastrar(jogo);
		}

		else{
			 retorno = jogoAplicacao.atualizar(jogo);
		}
		

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Jogo salvo com sucesso!");

		novoJogo = isNovo();

	}

	public void salvarMidia() {
		
		List<String> retorno;
		
			if(this.midia.getStatus() == null){
				this.midia.setJogo(jogo);
				this.jogo.getMidias().add(this.midia);
				this.jogoAplicacao.atualizar(jogo);
				this.midia.setStatus(StatusProduto.Disponivel);
				retorno = this.midiaAplicacao.cadastrar(this.midia);
				
			}
			else{
				retorno = this.midiaAplicacao.atualizar(this.midia);
			}

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}
			return;
		}


		FacesUtil.addInfoMessage("Midia salva com sucesso!");
		
		this.midia = new Midia();

	}
	
	public void excluirMidia(){
	
		
		jogo.getMidias().remove(this.midiaSelecionada);
		
		
		this.midiaAplicacao.excluir(this.midiaSelecionada);

		
		FacesUtil.addInfoMessage("Midia excluída com sucesso!");
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
