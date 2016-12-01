package com.alugagames.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.security.Seguranca;
import com.alugagames.security.UsuarioSistema;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.aplicacao.ConsoleAplicacao;
import alugagames.aplicacao.EquipamentoAplicacao;
import alugagames.aplicacao.MidiaAplicacao;
import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.alugueis.Aluguel;
import alugagames.core.consoles.Console;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.midias.Midia;
import alugagames.core.tiposconsole.TipoConsole;

@ManagedBean
@ViewScoped
public class AluguelReservaBean {

	private Aluguel aluguel;
	private AluguelAplicacao aluguelAplicacao;
	private List<Midia> jogos;
	private List<Console> consoles;
	private List<Equipamento> equipamentos;
	
	private List<TipoConsole> tiposConsole;

	private TipoConsole tipoConsole;
	private TipoConsole tipoConsoleJogo;
	private TipoConsole tipoConsoleEquipamento;
	
	public AluguelReservaBean() throws IOException {

		UsuarioSistema usuario = new Seguranca().getUsuarioLogado();

		this.aluguelAplicacao = new AluguelAplicacao();

		Aluguel aluguel = this.aluguelAplicacao.buscarPorCliente(usuario.getCliente());

		if (aluguel != null ) {
			this.aluguel = aluguel;
		} else {
			this.aluguel = aluguelAplicacao.abrirReserva(usuario.getCliente());
		}
		
		

		
		
		
	}
	
	public void inicializar(){
		
		this.tiposConsole = new TipoConsoleAplicacao().buscarTodos();
		this.tipoConsole = new TipoConsole();
		this.tipoConsoleJogo = new TipoConsole();
		this.tipoConsoleEquipamento = new TipoConsole();
		
		this.jogos = new MidiaAplicacao().buscarPorTipoConsole(null);
		this.consoles = new ConsoleAplicacao().buscarPorTipoConsole(null);
		this.equipamentos = new EquipamentoAplicacao().buscarPorTipoConsole(null);
		
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Midia> getJogos() {
		return jogos;
	}

	public List<Console> getConsoles() {
		return consoles;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public TipoConsole getTipoConsole() {
		return tipoConsole;
	}

	public void setTipoConsole(TipoConsole tipoConsole) {
		this.tipoConsole = tipoConsole;
	}

	public TipoConsole getTipoConsoleJogo() {
		return tipoConsoleJogo;
	}

	public void setTipoConsoleJogo(TipoConsole tipoConsoleJogos) {
		this.tipoConsoleJogo = tipoConsoleJogos;
	}

	public TipoConsole getTipoConsoleEquipamento() {
		return tipoConsoleEquipamento;
	}

	public void setTipoConsoleEquipamento(TipoConsole tipoConsoleEquipamento) {
		this.tipoConsoleEquipamento = tipoConsoleEquipamento;
	}

	public List<TipoConsole> getTiposConsole() {
		return tiposConsole;
	}
	
	
	

}
