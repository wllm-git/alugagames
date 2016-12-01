package com.alugagames.controller.aluguel;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;

@ManagedBean
@ViewScoped
public class AluguelCheckOutBean {
	private Aluguel aluguel;
	private AluguelAplicacao aluguelAplicacao;
	
	
	public AluguelCheckOutBean(Aluguel aluguel){
		this.aluguel = aluguel;
		
		aluguelAplicacao = new AluguelAplicacao();
	}
	
	public void cancelarAluguel(){
		
		
		List<String> retorno = aluguelAplicacao.cancelar(aluguel);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Reserva cancelada com sucesso!");
	}
	
	public void confirmarAluguel(){
		
		
		List<String> retorno = aluguelAplicacao.confirmarAluguel(aluguel);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Aluguel confirmado com sucesso!");
	}
	
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
