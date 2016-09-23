package alugagames.core.orcamentos;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import alugagames.core.os.TipoItemOS;

@Entity
public class OrcamentoItem {
	@Id
	@Column(length=16)
	private UUID id;
	private String numeroSerie;
	private String descricao;
	private double valor;
	//private TipoItemOS tipo;
	private boolean temConserto;
	@ManyToOne(fetch = FetchType.EAGER)
	private Orcamento orcamento;
	
	public OrcamentoItem(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

//	public TipoItemOS getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(TipoItemOS tipo) {
//		this.tipo = tipo;
//	}

	public boolean isTemConserto() {
		return temConserto;
	}

	public void setTemConserto(boolean temConserto) {
		this.temConserto = temConserto;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
	
}
