package alugagames.core.midias.regras;

import alugagames.core.midias.Midia;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.validacoesregras.IRegra;

public class MidiaPrecisaEstarDisponivel implements IRegra<Midia> {
	private IMidiaRepositorio _midiaRepositorio;
	
	public MidiaPrecisaEstarDisponivel(IMidiaRepositorio midiaRepositorio){
		_midiaRepositorio = midiaRepositorio;
	}
	
	@Override
	public String validar(Midia obj) {
		Midia m = _midiaRepositorio.buscarPorID(obj.getId());
		if(m == null)
			return "mídia "+ obj.getNumeroSerie() +" não está cadastrada no sistema.";
		else if(!m.getStatus().equals(StatusProduto.Disponivel))
			return "mídia "+ m.getNumeroSerie() +" não está disponível.";
		
		return null;
	}

}
