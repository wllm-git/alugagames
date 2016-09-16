package alugagames.core.consoles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import alugagames.core.jogos.Jogo;
import alugagames.core.tiposconsole.TipoConsole;

public class Console {
	
	private UUID id;
	private String numeroSerie;
	private Date ano;
	private List<Jogo> jogos;
	private TipoConsole tipoConsole;
	private int voltagem;
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
	
	public String getNumeroSerie() {
		return numeroSerie;
	}
	
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public TipoConsole getTipoConsole() {
		return tipoConsole;
	}

	public void setTipoConsole(TipoConsole tipoConsole) {
		this.tipoConsole = tipoConsole;
	}

	public List<? extends Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public int getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
