package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaTerNumeroSerieUnico implements IRegra<Midia> {

	private IMidiaRepositorio _repositorio;
	
	public MidiaPrecisaTerNumeroSerieUnico(IMidiaRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Midia obj) {
		Midia m = _repositorio.buscarPorNumeroSerie(obj.getNumeroSerie());
		
		if(m != null)
			return "Número de série " + obj.getNumeroSerie() + " já está em uso.";
		
		return null;
	}
}
