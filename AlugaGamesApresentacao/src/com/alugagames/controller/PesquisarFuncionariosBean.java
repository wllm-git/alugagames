package com.alugagames.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.filter.FuncionarioFilter;
import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.FuncionarioAplicacao;
import alugagames.core.funcionarios.Funcionario;


@ManagedBean
@ViewScoped
public class PesquisarFuncionariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionarioSelecionado;
	private List<Funcionario> funcionariosFiltrados;
	private FuncionarioFilter filtro;
	private boolean isPesquisa;
	
	public PesquisarFuncionariosBean(){
		this.isPesquisa = false;
	}
	
	public void inicializar(){
		this.funcionarioSelecionado = new Funcionario();
		
		if(!this.isPesquisa){
			this.funcionariosFiltrados = new FuncionarioAplicacao().buscarTodos();
		}
		this.filtro = new FuncionarioFilter();
	}
	
	public void excluirFuncionario(){
		
		
		new FuncionarioAplicacao().excluir(this.funcionarioSelecionado);
		
		inicializar();
		
		FacesUtil.addInfoMessage("O funcionário foi excluído com sucesso!");
		
	}
	
	
public void pesquisar(){
		
		this.funcionariosFiltrados.clear();
		
		if(!"".equals(this.filtro.getNome())){
			
			this.funcionariosFiltrados = new FuncionarioAplicacao().buscarPorNome(this.filtro.getNome());
		}
		
		else if(!"".equals(this.filtro.getEmail())){
			
			this.funcionariosFiltrados.add(new FuncionarioAplicacao().buscarPorEmail(this.filtro.getEmail()));
			
		}
		
		else if(!"".equals(this.filtro.getCpf())){
			
			this.funcionariosFiltrados.add(new FuncionarioAplicacao().buscarPorCpf(filtro.getCpf()));
			
		}
		
		else{
			inicializar();
			this.isPesquisa = false;
			return;
		}
		
		this.isPesquisa = true;
		
	}
	
	
	
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	public List<Funcionario> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}
	public void setFuncionariosFiltrados(List<Funcionario> funcionariosFiltrados) {
		this.funcionariosFiltrados = funcionariosFiltrados;
	}

	public FuncionarioFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(FuncionarioFilter filtro) {
		this.filtro = filtro;
	}
	
	
	
	
	
}
