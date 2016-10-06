package alugagames.core.os.repositorio;

import alugagames.core.os.OrdemServico;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IOrdemServicoRepositorio extends IRepositorioBase<OrdemServico> {
	public int getNextCodigo();
}
