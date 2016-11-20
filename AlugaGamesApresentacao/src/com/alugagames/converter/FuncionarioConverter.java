package com.alugagames.converter;

import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import alugagames.aplicacao.FuncionarioAplicacao;
import alugagames.core.funcionarios.Funcionario;

@FacesConverter(forClass= Funcionario.class)
public class FuncionarioConverter implements Converter {
	
private FuncionarioAplicacao funcionarioAplicacao;
	
	
	public FuncionarioConverter() {
		this.funcionarioAplicacao = new FuncionarioAplicacao();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String obj) {
		Funcionario retorno = null;
		
		if(obj!=null){
			UUID id = UUID.fromString(obj);
			retorno = funcionarioAplicacao.buscarPorID(id);
		}
		
		return retorno;
	
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {

		if(obj != null){
			return ((Funcionario) obj).getId().toString();
		}
		return "";
		
	}


}
