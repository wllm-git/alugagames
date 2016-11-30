package com.alugagames.controller.console;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.filter.JogoFilter;
import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.ConsoleAplicacao;
import alugagames.aplicacao.JogoAplicacao;
import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.consoles.Console;
import alugagames.core.jogos.Jogo;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.Voltagem;
import alugagames.core.tiposconsole.TipoConsole;

@ManagedBean
@ViewScoped
public class ConsoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Console console;

	private ConsoleAplicacao consoleAplicacao;
	private List<Voltagem> voltagens;
	private List<TipoConsole> consoles;
	private List<StatusProduto> status;
	private Jogo jogo;
	private boolean novo;

	private Jogo jogoSelecionado;
	private List<Jogo> jogosFiltrados;
	private JogoFilter filtro;
	private boolean isPesquisa;

	public ConsoleBean() {

		this.console = new Console();
		this.jogo = new Jogo();
		this.consoleAplicacao = new ConsoleAplicacao();
		this.voltagens = new ArrayList<>();
		this.consoles = new ArrayList<>();
		this.status = new ArrayList<>();
		this.isPesquisa = false;
		this.novo = isNovoConsole();

		getTodasVoltagens();
		getTodosConsoles();
		getTodosStatus();
	}

	public void inicializar() {

		this.jogoSelecionado = new Jogo();

		if (!this.isPesquisa) {
			this.jogosFiltrados = new JogoAplicacao().buscarTodos();
		
		}
		this.filtro = new JogoFilter();
		
		if(this.console.getNumeroSerie() !=null)
			this.novo = isNovoConsole();
		
		for (Jogo jogo : this.console.getJogos()) {
			jogosFiltrados.remove(jogo);
		}

	}

	public void salvarConsole() {
		List<String> retorno = this.consoleAplicacao.cadastrar(this.console);

		if (!retorno.isEmpty()) {
			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
				return;
			}
		}

		FacesUtil.addInfoMessage("Console cadastrado com sucesso");

		this.novo = isNovoConsole();
	}

	private void getTodosConsoles() {

		this.consoles = new TipoConsoleAplicacao().buscarTodos();

	}

	public void salvarJogoConsole() {
	
			
		this.console.getJogos().add(this.jogo);

		this.consoleAplicacao.atualizar(this.console);

		inicializar();

	}
	
	public void excluirJogoConsole(){
		
		this.console.getJogos().remove(jogoSelecionado);
		
		this.consoleAplicacao.atualizar(this.console);
		this.isPesquisa = false;
		
		inicializar();
		
		
	}

	public boolean isNovoConsole() {
		return this.console.getNumeroSerie() == null ? true : false;
	}

	private void getTodosStatus() {

		for (StatusProduto status : StatusProduto.values()) {
			this.status.add(status);
		}
	}

	private void getTodasVoltagens() {

		for (Voltagem voltagem : Voltagem.values()) {
			this.voltagens.add(voltagem);
		}
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

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean isNovo) {
		this.novo = isNovo;
	}

}
