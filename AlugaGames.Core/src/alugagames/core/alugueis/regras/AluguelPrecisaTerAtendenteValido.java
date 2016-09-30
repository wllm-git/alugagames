package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.atendentes.Atendente;
import alugagames.core.atendentes.AtendenteServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaTerAtendenteValido implements IRegra<Aluguel> {

	private AtendenteServico _atendenteServico;
	
	public AluguelPrecisaTerAtendenteValido(AtendenteServico atendenteServico){
		_atendenteServico = atendenteServico;
	}
	
	@Override
	public String validar(Aluguel obj) {
		if(obj.getAtendente() == null)
			return "atendente não informado.";
		
		Atendente a = _atendenteServico.buscarPorId(obj.getAtendente().getId());
		
		if(a == null)
			return "atendente não existe no sistema.";
		
		return null;
	}
}
