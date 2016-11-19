package com.alugagames.converter;

import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import alugagames.aplicacao.MidiaAplicacao;
import alugagames.core.midias.Midia;

@FacesConverter(forClass= Midia.class)
public class MidiaConverter implements Converter {
	
private MidiaAplicacao midiaAplicacao;
	
	
	public MidiaConverter() {
		this.midiaAplicacao = new MidiaAplicacao();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String obj) {
		Midia retorno = null;
		
		if(obj!=null){
			UUID id = UUID.fromString(obj);
			retorno = midiaAplicacao.buscarPorID(id);
		}
		
		return retorno;
	
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {

		if(obj != null){
			return ((Midia) obj).getId().toString();
		}
		return "";
		
	}


}
