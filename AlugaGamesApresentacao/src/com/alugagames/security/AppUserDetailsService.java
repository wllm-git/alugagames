package com.alugagames.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import alugagames.aplicacao.ClienteAplicacao;
import alugagames.aplicacao.FuncionarioAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcionario;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email)  {
		
		Cliente cliente = new ClienteAplicacao().buscarPorEmail(email);
		
		Funcionario funcionario = new FuncionarioAplicacao().buscarPorEmail(email);
		
		UsuarioSistema user = null;
		
		
		if(cliente != null){
			user = new UsuarioSistema(cliente, getGrupos(cliente));
		}
		
		if(funcionario != null){
			user = new UsuarioSistema(funcionario, getGrupos(funcionario));
		}
		
		
		return user;
	}
	
	

	private Collection<? extends GrantedAuthority> getGrupos(Funcionario funcionario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("FUNCIONARIO"));
		authorities.add(new SimpleGrantedAuthority(funcionario.getFuncao().toString().toUpperCase()));
		
		
		return authorities;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Cliente cliente) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("CLIENTE"));
		
		return authorities;
	}



}
