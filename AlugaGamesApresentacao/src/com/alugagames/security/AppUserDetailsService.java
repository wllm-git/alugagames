package com.alugagames.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import alugagames.aplicacao.ClienteAplicacao;
import alugagames.core.clientes.Cliente;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = new ClienteAplicacao().buscarPorEmail(email);
		
		
		if(cliente != null){
			//new UsuarioSistema(cliente, "");
		}
		
		
		return null;
	}

}
