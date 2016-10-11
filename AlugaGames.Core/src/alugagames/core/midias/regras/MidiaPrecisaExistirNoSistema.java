package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaExistirNoSistema implements IRegra<Midia> {

	private IMidiaRepositorio _repositorio;
	
	public MidiaPrecisaExistirNoSistema(IMidiaRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	@Override
	public String validar(Midia obj) {
		Midia m = _repositorio.buscarPorID(obj.getId());
		if(m == null)
			return "Midia "+ obj.getNumeroSerie() +" não cadastrada no sistema.";
		
		return null;
	}

}
