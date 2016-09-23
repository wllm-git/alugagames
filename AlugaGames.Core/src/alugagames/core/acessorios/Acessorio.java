package alugagames.core.acessorios;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import alugagames.core.shared.Produto;
import alugagames.core.shared.StatusProduto;

@Entity
public class Acessorio extends Produto {
	
	@Id
	@Column(length=16)
	private UUID id;
	
	public Acessorio(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
