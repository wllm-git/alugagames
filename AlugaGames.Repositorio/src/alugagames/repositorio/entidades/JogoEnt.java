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
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	@Override
	public Date getAnoLancamento() {
		// TODO Auto-generated method stub
		return super.getAnoLancamento();
	}

	@OneToMany(mappedBy="jogo", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@Override
	public List<MidiaEnt> getMidias() {
		// TODO Auto-generated method stub
		return (List<MidiaEnt>) super.getMidias();
	}

	@Override
	public float getPreco() {
		// TODO Auto-generated method stub
		return super.getPreco();
	}

}
