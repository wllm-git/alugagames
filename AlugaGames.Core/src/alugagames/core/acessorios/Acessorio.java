package alugagames.core.acessorios;

import java.util.UUID;

import alugagames.core.shared.Equipamento;

public class Acessorio extends Equipamento {
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
	
}
