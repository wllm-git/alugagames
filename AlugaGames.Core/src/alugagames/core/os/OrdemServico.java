package alugagames.core.os;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import alugagames.core.clientes.Cliente;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.orcamentos.Orcamento;

@Entity
public class OrdemServico {
	@Id
	@Column(length=16)
	private UUID id;
	private int codigo;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "atendente_id")
	private Funcionario atendente;
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Funcionario tecnico;
	private Date dataAbertura;
	private Date dataFechamento;
	private double valor;
	private String descricao;
	private StatusOS status;
	private boolean interna;
	@OneToOne
	@JoinColumn(name = "orcamento_id")
	private Orcamento orcamento;
	
	@OneToMany(mappedBy="ordemServico", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<OrdemServicoItem> ordemServicoItens;
	
	public OrdemServico(){
		id = UUID.randomUUID();
		ordemServicoItens = new ArrayList<>();
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

	public Funcionario getAtendente() {
		return atendente;
	}

	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}

	public Funcionario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Funcionario tecnico) {
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

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<OrdemServicoItem> getOrdemServicoItens() {
		return ordemServicoItens;
	}

	public void setOrdemServicoItens(List<OrdemServicoItem> ordemServicoItens) {
		this.ordemServicoItens = ordemServicoItens;
	}
	
	
}
