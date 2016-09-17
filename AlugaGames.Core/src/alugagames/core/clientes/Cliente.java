package alugagames.core.clientes;

import java.util.UUID;

public class Cliente {
	private UUID id;
	
	public Cliente(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
