package alugagames.core.equipamentos;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import alugagames.core.shared.Produto;
import alugagames.core.shared.StatusProduto;

@Entity
public class Equipamento extends Produto {
	
	@Id
	@Column(length=16)
	private UUID id;
	private TipoEquipamento tipoEquipamento;
	
	public Equipamento(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	@Override
	public String getNumeroSerie() {
		return super.getNumeroSerie();
	}

	@Override
	public StatusProduto getStatus() {
		return super.getStatus();
	}

	@Override
	public boolean isAtivo() {
		return super.isAtivo();
	}
	
	
}
