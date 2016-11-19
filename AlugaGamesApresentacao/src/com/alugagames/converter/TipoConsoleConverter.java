package com.alugagames.converter;

import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.tiposconsole.TipoConsole;

@FacesConverter(forClass= TipoConsole.class)
public class TipoConsoleConverter implements Converter{

	private TipoConsoleAplicacao tipoConsoleAplicacao;
	
	
	public TipoConsoleConverter() {
		this.tipoConsoleAplicacao = new TipoConsoleAplicacao();
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String obj) {
		TipoConsole retorno = null;
		
		if(obj!=null){
			UUID id = UUID.fromString(obj);
			retorno = tipoConsoleAplicacao.buscarPorID(id);
		}
		
		return retorno;
	
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {

		if(obj != null){
			return ((TipoConsole) obj).getId().toString();
		}
		return "";
		
	}

}
