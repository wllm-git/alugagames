package alugagames.core.atendentes;

import java.util.UUID;

import alugagames.core.atendentes.repositorio.IAtendenteRepositorio;

public class AtendenteServico {
	private IAtendenteRepositorio _repositorio;
	
	public AtendenteServico(IAtendenteRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public Atendente buscarPorId(UUID id){
		return _repositorio.buscarPorID(id);
	}
	
}
