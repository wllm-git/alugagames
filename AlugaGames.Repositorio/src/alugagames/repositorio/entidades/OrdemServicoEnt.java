package alugagames.repositorio.entidades;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.StatusOS;

@Entity(name = "OrdemServico")
public class OrdemServicoEnt extends OrdemServico{

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}

	@Override
	public int getCodigo() {
		return super.getCodigo();
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

	@Override
	public Date getDataAbertura() {
		return super.getDataAbertura();
	}

	@Override
	public Date getDataFechamento() {
		return super.getDataFechamento();
	}

	@Override
	public double getValor() {
		return super.getValor();
	}

	@Override
	public String getDescricao() {
		return super.getDescricao();
	}

	@Override
	public StatusOS getStatus() {
		return super.getStatus();
	}

	@Override
	public boolean isInterna() {
		return super.isInterna();
	}

	@OneToMany(mappedBy="ordemServico", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@Override
	public List<OrdemServicoItemEnt> getOrdemServicoItens() {
		return (List<OrdemServicoItemEnt>)super.getOrdemServicoItens();
	}

}
