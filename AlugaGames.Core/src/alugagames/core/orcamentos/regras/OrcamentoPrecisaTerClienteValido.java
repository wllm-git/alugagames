package alugagames.core.orcamentos.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisaTerClienteValido implements IRegra<Orcamento> {

	private ClienteServico _clienteServico;
	
	public OrcamentoPrecisaTerClienteValido(ClienteServico clienteServico) {
		_clienteServico = clienteServico;
	}

	@Override
	public String validar(Orcamento obj) {
		if(obj.getCliente() == null)
			return "Cliente não informado.";
		
		Cliente c = _clienteServico.buscarPorId(obj.getCliente().getId());
		if(c == null)
			return "Cliente não cadastrado.";
		
		return null;
	}

}
