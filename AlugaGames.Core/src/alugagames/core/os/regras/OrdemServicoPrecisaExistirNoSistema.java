package alugagames.core.os.regras;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaExistirNoSistema implements IRegra<OrdemServico> {

	private IOrdemServicoRepositorio _repositorio;
	
	public OrdemServicoPrecisaExistirNoSistema(IOrdemServicoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(OrdemServico obj) {
		OrdemServico o = _repositorio.buscarPorID(obj.getId());
		
		if(o == null)
			return "Ordem de serviço " + obj.getCodigo() + " não existe no sistema.";
		
		return null;
	}
}
