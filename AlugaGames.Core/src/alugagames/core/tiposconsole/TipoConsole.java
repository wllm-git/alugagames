package alugagames.core.tiposconsole;

import java.util.UUID;

public class TipoConsole {
	
	private UUID id;
	private String nome;
	
	public TipoConsole(){
		id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
