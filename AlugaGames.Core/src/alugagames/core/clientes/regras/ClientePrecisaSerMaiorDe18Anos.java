package alugagames.core.clientes.regras;

import java.util.Calendar;

import alugagames.core.clientes.Cliente;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaSerMaiorDe18Anos implements IRegra<Cliente> {

	@Override
	public String validar(Cliente obj) {
		Calendar data = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		
		d.setTime(obj.getDataNascimento());
		d.add(Calendar.YEAR, 18);
		
		if(!data.after(d))
			return "Cliente não pode ser menor de idade.";
		
		return null;
	}

}
