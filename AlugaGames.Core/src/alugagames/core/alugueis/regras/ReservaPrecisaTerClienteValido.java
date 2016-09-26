package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class ReservaPrecisaTerClienteValido implements IRegra<Aluguel> {

	private ClienteServico _clienteServico;
	
	public ReservaPrecisaTerClienteValido(ClienteServico clienteServico){
		_clienteServico = clienteServico;
	}
	
	@Override
	public String validar(Aluguel obj) {
		if(obj.getCliente() == null)
			return "Cliente não informado.";
		
		Cliente c = _clienteServico.buscarPorId(obj.getCliente().getId());
		if(c == null)
			return "Cliente informado não existe.";
		
		return null;
	}

}
