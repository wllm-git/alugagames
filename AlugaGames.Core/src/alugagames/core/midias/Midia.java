package alugagames.core.midias;

import java.util.UUID;

import alugagames.core.jogos.Jogo;
import alugagames.core.shared.Equipamento;
import alugagames.core.tiposconsole.TipoConsole;

public class Midia extends Equipamento {
	
	private UUID id;
	private Jogo jogo;
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

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public TipoConsole getTipoConsole() {
		return tipoConsole;
	}

	public void setTipoConsole(TipoConsole tipoConsole) {
		this.tipoConsole = tipoConsole;
	}

	
}
