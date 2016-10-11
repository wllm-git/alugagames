package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaTerNumeroSerieUnicoAlt implements IRegra<Midia> {
	private IMidiaRepositorio _repositorio;
	
	public MidiaPrecisaTerNumeroSerieUnicoAlt(IMidiaRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Midia obj) {
		Midia m = _repositorio.buscarPorNumeroSerie(obj.getNumeroSerie());
		
		if(m != null && !m.getId().equals(obj.getId()))
			return "Número de série " + obj.getNumeroSerie() + " já está em uso.";
		
		return null;
	}
}
