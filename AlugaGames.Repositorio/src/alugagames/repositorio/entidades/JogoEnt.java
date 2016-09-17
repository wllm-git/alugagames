package alugagames.repositorio.entidades;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import alugagames.core.jogos.Jogo;

@Entity(name="Jogo")
public class JogoEnt extends Jogo{
	
	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}

	@Override
	public String getNome() {
		return super.getNome();
	}

	@Override
	public Date getAnoLancamento() {
		return super.getAnoLancamento();
	}

	@OneToMany(mappedBy="jogo", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@Override
	public List<MidiaEnt> getMidias() {
		return (List<MidiaEnt>) super.getMidias();
	}

	@Override
	public float getPreco() {
		return super.getPreco();
	}

}
