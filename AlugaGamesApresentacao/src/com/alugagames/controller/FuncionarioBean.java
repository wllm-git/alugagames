package com.alugagames.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.FuncionarioAplicacao;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	private FuncionarioAplicacao funcionarioAplicacao;
	private List<Funcao> funcoes;

	public FuncionarioBean() {
		funcionario = new Funcionario();
		
		funcionarioAplicacao = new FuncionarioAplicacao();
		getTodasFuncoes();
		

	}

	public void salvarFuncionario() {

		formatarAtributosFuncionario();

		List<String> retorno = funcionarioAplicacao.cadastrar(funcionario);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Funcionário cadastrado com sucesso!");
		
		funcionario = new Funcionario();

	}
	
	private void getTodasFuncoes(){
		
			funcoes = new ArrayList<>();
			
			for (Funcao funcao : Funcao.values()) {
				funcoes.add(funcao);
			
		}
	}

	// Remove os caracteres especiais
	private void formatarAtributosFuncionario() {
		funcionario.setCpf(funcionario.getCpf().replace(".", "").replace("-", ""));
		funcionario.setTelefone(funcionario.getTelefone().replace("(", "").replace(")", "").replace("-", ""));
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	

	
	

}
