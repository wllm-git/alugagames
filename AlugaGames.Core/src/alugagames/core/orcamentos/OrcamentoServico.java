package alugagames.core.orcamentos;

import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;

public class OrcamentoServico {
	private IOrcamentoRepositorio _repositorio;
	
	public OrcamentoServico(IOrcamentoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	
}
