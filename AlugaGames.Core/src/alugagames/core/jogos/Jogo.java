package alugagames.core.jogos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import alugagames.core.midias.Midia;

public class Jogo {
	private UUID id;
	private String nome;
	private Date anoLancamento;
	private List<Midia> midias;
	private float preco;
	
	public Jogo(){
		id = UUID.randomUUID();
		midias = new ArrayList<>();
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

	public Date getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public List<? extends Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
