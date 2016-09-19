package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import alugagames.core.tecnicos.Tecnico;

@Entity(name = "Tecnico")
public class TecnicoEnt extends Tecnico{

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}
	
}
