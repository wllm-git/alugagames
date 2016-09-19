package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.os.TipoItemOS;

@Entity(name = "OrcamentoItem")
public class OrcamentoItemEnt extends OrcamentoItem{

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}

	@Override
	public String getDescricao() {
		return super.getDescricao();
	}

	@Override
	public String getNumeroSerie() {
		return super.getNumeroSerie();
	}

	@Override
	public double getValor() {
		return super.getValor();
	}

	@Override
	public TipoItemOS getTipo() {
		return super.getTipo();
	}

	@Override
	public boolean isTemConserto() {
		return super.isTemConserto();
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Override
	public OrcamentoEnt getOrcamento() {
		return (OrcamentoEnt)super.getOrcamento();
	}
	
}
