package com.alugagames.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.base.ClienteApresentacao;

import alugagames.aplicacao.ClienteAplicacao;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private ClienteApresentacao clienteApresentacao;
	
	
	public ClienteBean() {
		
	}
	
	
	
	
	public void salvar(){
		
		List<String> erros = new ClienteAplicacao().adicionarCliente(clienteApresentacao);
		
		if(!erros.isEmpty()){
			for (String erro : erros) {
				System.out.println(erro);
			}
		}
		
		System.out.println("Cliente salvo com sucesso!");
	}
	
	public void testarValores(){
		
		System.out.println(clienteApresentacao.getNome());
		System.out.println(clienteApresentacao.getCpf());
		System.out.println(clienteApresentacao.getRg());
		System.out.println(clienteApresentacao.getEmail());
		System.out.println(clienteApresentacao.getTelefone());
		System.out.println(clienteApresentacao.getCidade());
		System.out.println(clienteApresentacao.getUf());
		System.out.println(clienteApresentacao.getSenha());
		System.out.println(clienteApresentacao.getSexo());
	}


	public ClienteApresentacao getClienteApresentacao() {
		return clienteApresentacao;
	}


	public void setClienteApresentacao(ClienteApresentacao clienteApresentacao) {
		this.clienteApresentacao = clienteApresentacao;
	}



	
	
	
}
