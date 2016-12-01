package com.alugagames.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.security.Seguranca;
import com.alugagames.security.UsuarioSistema;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;

@ManagedBean
@ViewScoped
public class AluguelReservaBean {

	private Aluguel aluguel;
	private AluguelAplicacao aluguelAplicacao;

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

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

}
