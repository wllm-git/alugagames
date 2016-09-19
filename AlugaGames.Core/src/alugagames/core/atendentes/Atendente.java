package alugagames.core.atendentes;

import java.util.UUID;

public class Atendente {
	private UUID id;
	
	public Atendente(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
