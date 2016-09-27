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
			return "m�dia "+ obj.getNumeroSerie() +" n�o est� cadastrada no sistema.";
		else if(!m.getStatus().equals(StatusProduto.Disponivel))
			return "m�dia "+ m.getNumeroSerie() +" n�o est� dispon�vel.";
		
		return null;
	}

}
