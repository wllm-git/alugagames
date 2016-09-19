package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.StatusOSItem;
import alugagames.core.os.TipoItemOS;

@Entity(name = "OrdemServicoItem")
public class OrdemServicoItemEnt extends OrdemServicoItem {

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
	public StatusOSItem getStatusOSItem() {
		return super.getStatusOSItem();
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Override
	public OrdemServicoEnt getOrdemServico() {
		return (OrdemServicoEnt)super.getOrdemServico();
	}
	
}
