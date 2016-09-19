package alugagames.core.orcamentos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import alugagames.core.atendentes.Atendente;
import alugagames.core.clientes.Cliente;
import alugagames.core.tecnicos.Tecnico;

public class Orcamento {
	private UUID id;
	private Cliente cliente;
	private Atendente atendente;
	private Tecnico tecnico;
	private List<OrcamentoItem> orcamentoItens;
	
	public Orcamento(){
		id = UUID.randomUUID();
		orcamentoItens = new ArrayList<>();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<? extends OrcamentoItem> getOrcamentoItens() {
		return orcamentoItens;
	}

	public void setOrcamentoItens(List<OrcamentoItem> orcamentoItens) {
		this.orcamentoItens = orcamentoItens;
	}

	
}
