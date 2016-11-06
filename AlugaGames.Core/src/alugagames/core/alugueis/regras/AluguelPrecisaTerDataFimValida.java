package alugagames.core.alugueis.regras;

import java.util.Calendar;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaTerDataFimValida implements IRegra<Aluguel> {

	@Override
	public String validar(Aluguel obj) {
		if(obj.getDataAluguelFim() == null)
			return "Data de devolu��o n�o informada.";
		else if(obj.getDataAluguelInicio() == null)
			return "N�o foi poss�vel validar a data de devolu��o.";
		
		Calendar inicio = Calendar.getInstance();
		inicio.setTime(obj.getDataAluguelInicio());
		
		Calendar fim = Calendar.getInstance();
		fim.setTime(obj.getDataAluguelFim());
		
		if(!inicio.before(fim))
			return "Data de devolu��o inv�lida.";
		
		return null;
	}

}
