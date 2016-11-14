package com.alugagames.security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@ManagedBean
@RequestScoped
public class Seguranca {

	public String getNomeUsuario() {
		String nome = null;

		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			if(usuarioLogado.getCliente() != null){
				nome = usuarioLogado.getCliente().getNome();
				return nome;
			}
			if(usuarioLogado.getFuncionario() != null ){
				nome = usuarioLogado.getFuncionario().getNome();
			}
		}
		return nome;
	}

	// Retorna o usuário logado no sistema
	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;

		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}

		return usuario;
	}

}
