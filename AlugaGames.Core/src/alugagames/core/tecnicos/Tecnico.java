package alugagames.core.tecnicos;

import java.util.UUID;

public class Tecnico {
	private UUID id;
	
	public Tecnico(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
