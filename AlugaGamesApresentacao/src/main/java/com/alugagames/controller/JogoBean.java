package com.alugagames.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.alugagames.base.JogoApresentacao;

import alugagames.aplicacao.JogoAplicacao;

@ManagedBean
@ApplicationScoped
public class JogoBean{

	
	JogoApresentacao jogoApresentacao;
	
	
	public JogoBean() {
		jogoApresentacao = new JogoApresentacao();
	}
	
	public void salvar(){
		
		
		
		List<String> retorno = new JogoAplicacao().cadastrar(jogoApresentacao);
		
		if(retorno.isEmpty()){
			
		}
		
	}
	
	
	
	
}
