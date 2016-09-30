package alugagames.repositorio;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;

public class OrdemServicoRepositorio extends RepositorioBase<OrdemServico> implements IOrdemServicoRepositorio{

	public OrdemServicoRepositorio() {
		super(OrdemServico.class);
	}

}
