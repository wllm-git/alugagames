package com.alugagames.filter;

import java.io.Serializable;

public class ClienteFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String email;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
