package alugagames.repositorio.entidades;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import alugagames.core.orcamentos.Orcamento;

@Entity(name = "Orcamento")
public class OrcamentoEnt extends Orcamento{

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
		return (ClienteEnt)super.getCliente();
	}

	@ManyToOne
	@JoinColumn(name = "atendente_id")
	@Override
	public AtendenteEnt getAtendente() {
		return (AtendenteEnt)super.getAtendente();
	}

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	@Override
	public TecnicoEnt getTecnico() {
		return (TecnicoEnt)super.getTecnico();
	}

	@OneToMany(mappedBy="orcamento", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@Override
	public List<OrcamentoItemEnt> getOrcamentoItens() {
		return (List<OrcamentoItemEnt>)super.getOrcamentoItens();
	}
	
}
