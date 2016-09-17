package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import alugagames.core.tiposconsole.TipoConsole;

@Entity(name="TipoConsole")
public class TipoConsoleEnt extends TipoConsole{

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}

	@Override
	public String getNome() {
		return super.getNome();
	}
	
}
