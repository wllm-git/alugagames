package com.alugagames.controller.cliente;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.filter.ClienteFilter;
import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.ClienteAplicacao;
import alugagames.core.clientes.Cliente;

@ManagedBean
@ViewScoped
public class PesquisarClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente clienteSelecionado;
	private List<Cliente> clientesFiltrados;
	private ClienteFilter filtro;
	private boolean isPesquisa;
	
	public PesquisarClientesBean(){
		isPesquisa = false;
	}
	
	
	public void inicializar(){
		this.clienteSelecionado = new Cliente();
		
		if(!isPesquisa){
			this.clientesFiltrados = new ClienteAplicacao().buscarTodos();
		}
		this.filtro = new ClienteFilter();
	}
	
	public void excluirCliente(){
		
		
		new ClienteAplicacao().excluir(this.clienteSelecionado);
		
		inicializar();
		
		
		FacesUtil.addInfoMessage("O cliente foi excluído com sucesso!");
		
	}
	
	public void pesquisar(){
		
		this.clientesFiltrados.clear();
		
		if(!"".equals(this.filtro.getNome())){
			
			this.clientesFiltrados = new ClienteAplicacao().buscarPorNome(this.filtro.getNome());
		}
		
		else if(!"".equals(this.filtro.getEmail())){
			
			this.clientesFiltrados.add(new ClienteAplicacao().buscarPorEmail(this.filtro.getEmail()));
			
		}
		
		else if(!"".equals(this.filtro.getCpf())){
			
			this.clientesFiltrados.add(new ClienteAplicacao().buscarPorCpf(filtro.getCpf()));
			
		}
		
		else{
			inicializar();
			isPesquisa = false;
			return;
		}
		
		isPesquisa = true;
		
	}
	
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}
	public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
		this.clientesFiltrados = clientesFiltrados;
	}

	public ClienteFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ClienteFilter filtro) {
		this.filtro = filtro;
	}
	
	
	
	
}
