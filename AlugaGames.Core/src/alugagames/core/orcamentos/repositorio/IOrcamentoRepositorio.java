package alugagames.core.orcamentos.repositorio;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IOrcamentoRepositorio extends IRepositorioBase<Orcamento>{

	public int getNextCodigo();

	public Orcamento buscarPorCodigo(int codigo);

}
