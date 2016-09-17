package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import alugagames.core.midias.Midia;

@Entity(name="Midia")
public class MidiaEnt extends Midia{

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}

	@Override
	public String getNumeroSerie() {
		return super.getNumeroSerie();
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@Override
	public JogoEnt getJogo() {
		return (JogoEnt)super.getJogo();
	}

	@OneToOne
	@JoinColumn(name = "tipoconsole_id")
	@Override
	public TipoConsoleEnt getTipoConsole() {
		return (TipoConsoleEnt)super.getTipoConsole();
	}

}
