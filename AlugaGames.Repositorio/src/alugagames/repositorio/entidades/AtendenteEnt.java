package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import alugagames.core.atendentes.Atendente;

@Entity(name = "Atendente")
public class AtendenteEnt extends Atendente{
	
	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}
}
