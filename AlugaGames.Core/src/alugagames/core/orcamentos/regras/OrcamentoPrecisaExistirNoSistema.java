package alugagames.core.orcamentos.regras;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaExistirNoSistema implements IRegra<Orcamento>{

	private IOrcamentoRepositorio _repositorio;
	
	public OrcamentoPrecisaExistirNoSistema(IOrcamentoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Orcamento obj) {
		Orcamento o = _repositorio.buscarPorID(obj.getId());
		
		if(o == null)
			return "O orçamento " + obj.getCodigo() + " não existe no sistema.";
		
		return null;
	}

}
