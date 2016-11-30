package alugagames.core.alugueis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import alugagames.core.clientes.Cliente;
import alugagames.core.consoles.Console;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.funcionarios.Funcionario;
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
	@JoinColumn(name = "atendenteConfirmacao_id")
	private Funcionario atendenteConfirmacao;
	
	@ManyToOne
	@JoinColumn(name = "atendenteFechamento_id")
	private Funcionario atendenteFechamento;
	
	@Enumerated(EnumType.STRING)
	private StatusAluguel status;
	
	private Date dataAluguelInicio;
	private Date dataAluguelFim;
	
	private Date dataReserva;
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
	private List<Equipamento> equipamentos;
	
	public Aluguel(){
		id = UUID.randomUUID();
		status = StatusAluguel.Aberto;
		consoles = new ArrayList<>();
		midias = new ArrayList<>();
		equipamentos = new ArrayList<>();
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

	public Funcionario getAtendenteConfirmacao() {
		return atendenteConfirmacao;
	}

	public void setAtendenteConfirmacao(Funcionario atendenteConfirmacao) {
		this.atendenteConfirmacao = atendenteConfirmacao;
	}
	
	public Funcionario getAtendenteFechamento() {
		return atendenteFechamento;
	}

	public void setAtendenteFechamento(Funcionario atendenteFechamento) {
		this.atendenteFechamento = atendenteFechamento;
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

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
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

	public Date getDataAluguelInicio() {
		return dataAluguelInicio;
	}

	public void setDataAluguelInicio(Date dataAluguelInicio) {
		this.dataAluguelInicio = dataAluguelInicio;
	}

	public Date getDataAluguelFim() {
		return dataAluguelFim;
	}

	public void setDataAluguelFim(Date dataAluguelFim) {
		this.dataAluguelFim = dataAluguelFim;
	}

	public boolean isAluguel() {
		return (status != StatusAluguel.Aberto && status != StatusAluguel.Reservado && status != StatusAluguel.Cancelado)
				|| (status == StatusAluguel.Cancelado && dataConfirmacao != null);
	}
	
}
