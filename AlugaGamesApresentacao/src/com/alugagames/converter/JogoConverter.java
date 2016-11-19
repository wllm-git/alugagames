package com.alugagames.converter;

import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import alugagames.aplicacao.JogoAplicacao;
import alugagames.core.jogos.Jogo;

@FacesConverter(forClass= Jogo.class)
public class JogoConverter implements Converter {
	
private JogoAplicacao jogoAplicacao;
	
	
	public JogoConverter() {
		this.jogoAplicacao = new JogoAplicacao();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String obj) {
		Jogo retorno = null;
		
		if(obj!=null){
			UUID id = UUID.fromString(obj);
			retorno = jogoAplicacao.buscarPorID(id);
		}
		
		return retorno;
	
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {

		if(obj != null){
			return ((Jogo) obj).getId().toString();
		}
		return "";
		
	}


}
