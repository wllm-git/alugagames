package com.alugagames.controller;

import java.util.List;

import alugagames.aplicacao.JogoAplicacao;
import alugagames.core.jogos.Jogo;

public class TesteLogin {

	public static void main(String[] args) throws Exception {


		List<Jogo> jogos = new JogoAplicacao().buscarTodos();
		
		for (Jogo jogo : jogos) {
			System.out.println(jogo.getNome());
		}
		
	}

}
