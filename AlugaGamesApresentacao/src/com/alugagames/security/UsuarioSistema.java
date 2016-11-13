package com.alugagames.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.CriptografiaDES;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private Funcionario funcionario;

	
	public UsuarioSistema(Cliente cliente, Collection<? extends GrantedAuthority> authorities) {
		super(cliente.getEmail(), CriptografiaDES.decriptar(cliente.getSenha()) , authorities);
		this.cliente = cliente;
	}
	
	public UsuarioSistema(Funcionario funcionario, Collection<? extends GrantedAuthority> authorities) {
		super(funcionario.getEmail(), CriptografiaDES.decriptar(funcionario.getSenha()), authorities);
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}

	
	
	


	

}
