package com.alugagames.controller.orcamento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import alugagames.aplicacao.OrcamentoAplicacao;
import alugagames.core.orcamentos.Orcamento;

@ManagedBean
@ViewScoped
public class FazerOrcamentoBean {
	private Orcamento orcamento;
	private OrcamentoAplicacao orcamentoAplicacao;
	
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
}
