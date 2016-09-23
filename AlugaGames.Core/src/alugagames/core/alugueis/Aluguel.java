package alugagames.core.alugueis;

import java.util.ArrayList;
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

import alugagames.core.acessorios.Acessorio;
import alugagames.core.atendentes.Atendente;
import alugagames.core.clientes.Cliente;
import alugagames.core.consoles.Console;
import alugagames.core.midias.Midia;

@Entity
public class Aluguel {
	@Id
	@Column(length=16)
	private UUID id;
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "atendente_id")
	private Atendente atendente;
	
	private StatusAluguel status;
	
	private Date dataAbertura;
	private Date dataConfirmacao;
	private Date dataFechamento;
	
	@ManyToMany
	@JoinTable(name = "AluguelConsole", 
				joinColumns = @JoinColumn(name = "AluguelId"), 
				inverseJoinColumns = @JoinColumn(name = "ConsoleId"))
	private List<Console> consoles;
	
	@ManyToMany
	@JoinTable(name = "AluguelMidia", 
				joinColumns = @JoinColumn(name = "AluguelId"), 
				inverseJoinColumns = @JoinColumn(name = "MidiaId"))
	private List<Midia> midias;
	
	@ManyToMany
	@JoinTable(name = "AluguelAcessorio", 
				joinColumns = @JoinColumn(name = "AluguelId"), 
				inverseJoinColumns = @JoinColumn(name = "AcessorioId"))
	private List<Acessorio> acessorios;
	
	public Aluguel(){
		id = UUID.randomUUID();
		status = StatusAluguel.Aberto;
		consoles = new ArrayList<>();
		midias = new ArrayList<>();
		acessorios = new ArrayList<>();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public List<Console> getConsoles() {
		return consoles;
	}

	public void setConsoles(List<Console> consoles) {
		this.consoles = consoles;
	}

	public List<Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(Date dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public StatusAluguel getStatus() {
		return status;
	}

	public void setStatus(StatusAluguel status) {
		this.status = status;
	}
	
}