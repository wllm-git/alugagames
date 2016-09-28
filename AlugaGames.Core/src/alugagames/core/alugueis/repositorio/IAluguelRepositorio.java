package alugagames.core.alugueis.repositorio;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IAluguelRepositorio extends IRepositorioBase<Aluguel>{

	public int getNextCodigo();
	
	public Aluguel buscarPorCodigo(int codigo);
}
