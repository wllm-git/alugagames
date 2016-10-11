package alugagames.core.midias.repositorio;

import alugagames.core.midias.Midia;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IMidiaRepositorio extends IRepositorioBase<Midia>{

	public void atualizarStatusMidia(Midia midia);

	public Midia buscarPorNumeroSerie(String numeroSerie);
	
}
