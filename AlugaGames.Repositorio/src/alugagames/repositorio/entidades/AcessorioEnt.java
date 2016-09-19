package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import alugagames.core.acessorios.Acessorio;
import alugagames.core.shared.StatusEquipamento;

@Entity(name="Acessorio")
public class AcessorioEnt extends Acessorio{

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}
	
	@Override
	public StatusEquipamento getStatus() {
		return super.getStatus();
	}

	@Override
	public boolean isAtivo() {
		return super.isAtivo();
	}

	@Override
	public String getNumeroSerie() {
		return super.getNumeroSerie();
	}
	
}
