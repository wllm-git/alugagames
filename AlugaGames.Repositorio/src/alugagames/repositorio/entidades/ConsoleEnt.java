package alugagames.repositorio.entidades;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import alugagames.core.consoles.Console;
import alugagames.core.jogos.Jogo;

@Entity(name="Console")
public class ConsoleEnt extends Console{

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public String getNumeroSerie() {
		// TODO Auto-generated method stub
		return super.getNumeroSerie();
	}

	@Override
	public Date getAno() {
		// TODO Auto-generated method stub
		return super.getAno();
	}

	@OneToOne
	@JoinColumn(name = "tipoconsole_id")
	@Override
	public TipoConsoleEnt getTipoConsole() {
		// TODO Auto-generated method stub
		return (TipoConsoleEnt)super.getTipoConsole();
	}
	
	@ManyToMany
	@JoinTable(name = "ConsoleJogo", 
				joinColumns = @JoinColumn(name = "ConsoleId"), 
				inverseJoinColumns = @JoinColumn(name = "JogoId"))
	@Override
	public List<JogoEnt> getJogos() {
		// TODO Auto-generated method stub
		return (List<JogoEnt>) super.getJogos();
	}

	@Override
	public int getVoltagem() {
		// TODO Auto-generated method stub
		return super.getVoltagem();
	}

	@Override
	public float getPreco() {
		// TODO Auto-generated method stub
		return super.getPreco();
	}
	
}
