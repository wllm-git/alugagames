package alugagames.core.midias;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import alugagames.core.jogos.Jogo;
import alugagames.core.shared.Produto;
import alugagames.core.shared.StatusProduto;
import alugagames.core.tiposconsole.TipoConsole;

@Entity
public class Midia extends Produto {
	
	@Id
	@Column(length=16)
	private UUID id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Jogo jogo;
	@OneToOne
	@JoinColumn(name = "tipoconsole_id")
	private TipoConsole tipoConsole;
	private float preco;
	
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
