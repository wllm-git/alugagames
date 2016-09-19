package alugagames.core.os;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import alugagames.core.atendentes.Atendente;
import alugagames.core.clientes.Cliente;
import alugagames.core.tecnicos.Tecnico;

public class OrdemServico {
	
	private UUID id;
	private int codigo;
	private Cliente cliente;
	private Atendente atendente;
	private Tecnico tecnico;
	private Date dataAbertura;
	private Date dataFechamento;
	private double valor;
	private String descricao;
	private StatusOS status;
	private boolean interna;
	private List<OrdemServicoItem> ordemServicoItens;
	
	public OrdemServico(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusOS getStatus() {
		return status;
	}

	public void setStatus(StatusOS status) {
		this.status = status;
	}

	public boolean isInterna() {
		return interna;
	}

	public void setInterna(boolean interna) {
		this.interna = interna;
	}

	public List<? extends OrdemServicoItem> getOrdemServicoItens() {
		return ordemServicoItens;
	}

	public void setOrdemServicoItens(List<OrdemServicoItem> ordemServicoItens) {
		this.ordemServicoItens = ordemServicoItens;
	}
	
	
}
