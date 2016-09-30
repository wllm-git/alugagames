package alugagames.repositorio;

import alugagames.core.atendentes.Atendente;
import alugagames.core.atendentes.repositorio.IAtendenteRepositorio;

public class AtendenteRepositorio extends RepositorioBase<Atendente> implements IAtendenteRepositorio {

	public AtendenteRepositorio() {
		super(Atendente.class);
	}

}
