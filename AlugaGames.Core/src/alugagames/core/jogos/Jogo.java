package alugagames.core.jogos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import alugagames.core.midias.Midia;

@Entity
public class Jogo {
	@Id
	@Column(length=16)
	private UUID id;
	private String nome;
	private Categoria categoria;
	private String anoLancamento;
	@OneToMany(mappedBy="jogo", fetch = FetchType.LAZY)
	private List<Midia> midias;
	
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public List<Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

}
