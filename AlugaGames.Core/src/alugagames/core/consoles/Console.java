package alugagames.core.consoles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import alugagames.core.jogos.Jogo;
import alugagames.core.shared.Produto;
import alugagames.core.shared.Voltagem;
import alugagames.core.tiposconsole.TipoConsole;

@Entity
public class Console extends Produto {
	
	@Id
	@Column(length=16)
	private UUID id;
	
	private String ano;
	@ManyToMany
	@JoinTable(name = "ConsoleJogo", 
				joinColumns = @JoinColumn(name = "ConsoleId"), 
				inverseJoinColumns = @JoinColumn(name = "JogoId"))
	private List<Jogo> jogos;
	@OneToOne
	@JoinColumn(name = "tipoconsole_id")
	private TipoConsole tipoConsole;
	private Voltagem voltagem;
	private float preco;
	
	public Console(){
		id = UUID.randomUUID();
		jogos = new ArrayList<>();
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public TipoConsole getTipoConsole() {
		return tipoConsole;
	}

	public void setTipoConsole(TipoConsole tipoConsole) {
		this.tipoConsole = tipoConsole;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Voltagem getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(Voltagem voltagem) {
		this.voltagem = voltagem;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}	
}
