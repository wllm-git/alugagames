package com.alugagames.converter;

import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import alugagames.aplicacao.ClienteAplicacao;
import alugagames.core.clientes.Cliente;

@FacesConverter(forClass= Cliente.class)
public class ClienteConverter implements Converter {
	
private ClienteAplicacao clienteAplicacao;
	
	
	public ClienteConverter() {
		this.clienteAplicacao = new ClienteAplicacao();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String obj) {
		Cliente retorno = null;
		
		if(obj!=null){
			UUID id = UUID.fromString(obj);
			retorno = clienteAplicacao.buscarPorID(id);
		}
		
		return retorno;
	
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {

		if(obj != null){
			return ((Cliente) obj).getId().toString();
		}
		return "";
		
	}


}
