package com.alugagames.base;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import alugagames.core.jogos.Jogo;
import alugagames.core.midias.Midia;

public class JogoApresentacao extends Jogo{

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

	@Override
	public List<Midia> getMidias() {
		return super.getMidias();
	}
}
