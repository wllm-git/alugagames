package com.alugagames.controller;

import alugagames.aplicacao.ClienteAplicacao;
import alugagames.aplicacao.FuncionarioAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcionario;

public class TesteLogin {

	public static void main(String[] args) throws Exception {

		logar("roldao.wilker@gmail.com", "123120");

	}

	public static void logar(String email, String senha) {

		
		
		Cliente cliente;
		try {
			cliente = new ClienteAplicacao().logar(email, senha);
			if (cliente != null) {
				System.out.println("Cliente");
				return;
			}
		} catch (Exception e) {

		}

		Funcionario funcionario;
		try {
			funcionario = new FuncionarioAplicacao().logar(email, senha);
			if (funcionario != null) {
				System.out.println("Funcionário");
			}

		} catch (Exception e1) {
			e1.getMessage();
		}

	}

}
