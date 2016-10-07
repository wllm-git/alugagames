package alugagames.core.funcionarios.regras;

import java.util.Calendar;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaSerMaiorDe18Anos implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		
		Calendar data = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		
		d.setTime(obj.getDataNascimento());
		d.add(Calendar.YEAR, 18);
		
		if(!data.after(d))
			return "Funcionário não pode ser menor de idade.";
		
		return null;
	}

}
