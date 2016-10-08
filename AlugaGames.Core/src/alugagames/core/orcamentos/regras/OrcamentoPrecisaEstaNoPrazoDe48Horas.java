package alugagames.core.orcamentos.regras;

import java.util.Calendar;

import alugagames.core.orcamentos.Orcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaEstaNoPrazoDe48Horas implements IRegra<Orcamento> {

	@Override
	public String validar(Orcamento obj) {
		Calendar dataLimite = Calendar.getInstance();
		
		dataLimite.setTime(obj.getDataAbertura());
		dataLimite.add(Calendar.HOUR, 48);
		
		Calendar hoje = Calendar.getInstance();
		
		if(hoje.after(dataLimite))
			return "Orçamento "+ obj.getCodigo()+ " fora do prazo de 48 horas.";
		
		return null;
	}

}
