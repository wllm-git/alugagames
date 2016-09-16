package alugagames.core.midias;

import java.util.UUID;

import alugagames.core.jogos.Jogo;
import alugagames.core.tiposconsole.TipoConsole;

public class Midia {
	
	private UUID id;
	private String numeroSerie;
	private Jogo jogo;
	private boolean disponivel;
	private TipoConsole tipoConsole;
	
	
	public Midia(){
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public TipoConsole getTipoConsole() {
		return tipoConsole;
	}

	public void setTipoConsole(TipoConsole tipoConsole) {
		this.tipoConsole = tipoConsole;
	}

	
}
