package com.alugagames.converter;

import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import alugagames.aplicacao.ConsoleAplicacao;
import alugagames.core.consoles.Console;

@FacesConverter(forClass= Console.class)
public class ConsoleConverter implements Converter {
	
private ConsoleAplicacao consoleAplicacao;
	
	
	public ConsoleConverter() {
		this.consoleAplicacao = new ConsoleAplicacao();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String obj) {
		Console retorno = null;
		
		if(obj!=null){
			UUID id = UUID.fromString(obj);
			retorno = consoleAplicacao.buscarPorID(id);
		}
		
		return retorno;
	
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {

		if(obj != null){
			return ((Console) obj).getId().toString();
		}
		return "";
		
	}


}
