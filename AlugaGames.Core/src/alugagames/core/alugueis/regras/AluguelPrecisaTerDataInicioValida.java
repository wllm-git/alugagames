package alugagames.core.alugueis.regras;

import java.util.Calendar;
import java.util.Date;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaTerDataInicioValida implements IRegra<Aluguel> {

	@Override
	public String validar(Aluguel obj) {
		if(obj.getDataAluguelInicio() == null)
			return "Data de início não informada.";
		
		Calendar inicio = Calendar.getInstance();
		inicio.setTime(obj.getDataAluguelInicio());
		
		Calendar hoje = Calendar.getInstance();
		hoje.setTime(new Date());
		
		if(!inicio.after(hoje))
			return "Data de início inválida.";
		
		return null;
	}

}
