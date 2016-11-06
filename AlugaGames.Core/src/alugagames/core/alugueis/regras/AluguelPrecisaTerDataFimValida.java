package alugagames.core.alugueis.regras;

import java.util.Calendar;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaTerDataFimValida implements IRegra<Aluguel> {

	@Override
	public String validar(Aluguel obj) {
		if(obj.getDataAluguelFim() == null)
			return "Data de devolução não informada.";
		else if(obj.getDataAluguelInicio() == null)
			return "Não foi possível validar a data de devolução.";
		
		Calendar inicio = Calendar.getInstance();
		inicio.setTime(obj.getDataAluguelInicio());
		
		Calendar fim = Calendar.getInstance();
		fim.setTime(obj.getDataAluguelFim());
		
		if(!inicio.before(fim))
			return "Data de devolução inválida.";
		
		return null;
	}

}
