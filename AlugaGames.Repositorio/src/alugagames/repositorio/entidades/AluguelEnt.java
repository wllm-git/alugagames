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
import javax.persistence.ManyToOne;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.StatusAluguel;

@Entity(name="Aluguel")
public class AluguelEnt extends Aluguel {

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@Override
	public ClienteEnt getCliente() {
		return (ClienteEnt) super.getCliente();
	}

	@ManyToMany
	@JoinTable(name = "AluguelConsole", 
				joinColumns = @JoinColumn(name = "AluguelId"), 
				inverseJoinColumns = @JoinColumn(name = "ConsoleId"))
	@Override
	public List<ConsoleEnt> getConsoles() {
		return (List<ConsoleEnt>) super.getConsoles();
	}

	@ManyToMany
	@JoinTable(name = "AluguelMidia", 
				joinColumns = @JoinColumn(name = "AluguelId"), 
				inverseJoinColumns = @JoinColumn(name = "MidiaId"))
	@Override
	public List<MidiaEnt> getMidias() {
		return (List<MidiaEnt>) super.getMidias();
	}

	@ManyToMany
	@JoinTable(name = "AluguelAcessorio", 
				joinColumns = @JoinColumn(name = "AluguelId"), 
				inverseJoinColumns = @JoinColumn(name = "AcessorioId"))
	@Override
	public List<AcessorioEnt> getAcessorios() {
		return (List<AcessorioEnt>)super.getAcessorios();
	}

	@Override
	public Date getDataAbertura() {
		return super.getDataAbertura();
	}

	@Override
	public Date getDataConfirmacao() {
		return super.getDataConfirmacao();
	}

	@Override
	public Date getDataFechamento() {
		return super.getDataFechamento();
	}

	@Override
	public int getCodigo() {
		return super.getCodigo();
	}

	@Override
	public StatusAluguel getStatus() {
		return super.getStatus();
	}

}
