package alugagames.core.orcamentos;

import java.util.UUID;

import alugagames.core.os.TipoItemOS;

public class OrcamentoItem {
	
	private UUID id;
	private String descricao;
	private String numeroSerie;
	private double valor;
	private TipoItemOS tipo;
	private boolean temConserto;
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

	public TipoItemOS getTipo() {
		return tipo;
	}

	public void setTipo(TipoItemOS tipo) {
		this.tipo = tipo;
	}

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
