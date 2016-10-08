package alugagames.core.os;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdemServicoItem {
	@Id
	@Column(length=16)
	private UUID id;
	private String descricao;
	private String numeroSerie;
	private double valor;
	private StatusOSItem statusOSItem;
	@ManyToOne(fetch = FetchType.EAGER)
	private OrdemServico ordemServico;

	public OrdemServicoItem(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public StatusOSItem getStatusOSItem() {
		return statusOSItem;
	}

	public void setStatusOSItem(StatusOSItem statusOSItem) {
		this.statusOSItem = statusOSItem;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
}
