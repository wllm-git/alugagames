package com.alugagames.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alugagames.util.FacesUtil;

import alugagames.aplicacao.ClienteAplicacao;
import alugagames.core.clientes.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private ClienteAplicacao clienteAplicacao;

	public ClienteBean() {
		cliente = new Cliente();

		clienteAplicacao = new ClienteAplicacao();
	}

	public void teste() {

		formatarAtributosCliente();

		List<String> retorno = clienteAplicacao.adicionarCliente(cliente);

		if (!retorno.isEmpty()) {

			for (String erro : retorno) {
				FacesUtil.addErrorMessage(erro);
			}

			return;
		}

		FacesUtil.addInfoMessage("Cliente cadastrado com sucesso!");
		
		cliente = new Cliente();

	}

	// Remove os caracteres especiais
	private void formatarAtributosCliente() {
		cliente.setCpf(cliente.getCpf().replace(".", "").replace("-", ""));
		cliente.setTelefone(cliente.getTelefone().replace("(", "").replace(")", "").replace("-", ""));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
