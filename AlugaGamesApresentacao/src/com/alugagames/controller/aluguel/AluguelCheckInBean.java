package com.alugagames.controller.aluguel;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;

@ManagedBean
@ViewScoped
public class AluguelCheckInBean {
	private Aluguel aluguel;
	private AluguelAplicacao aluguelAplicacao;
	
	public AluguelCheckInBean(){
		
	}
	
	public AluguelCheckInBean(Aluguel aluguel){
		this.aluguel = aluguel;
		
		aluguelAplicacao = new AluguelAplicacao();
	}
	
	public void finalizarAluguel(){
		
		
		List<String> retorno = aluguelAplicacao.finalizarAluguel(aluguel);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Cliente cadastrado com sucesso!");
		
		//TODO falta redirecionar para outra tela.
	}
	
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
