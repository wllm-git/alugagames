package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaExistirNoSistema implements IRegra<Cliente> {

	private IClienteRepositorio _repositorio;
	
	public ClientePrecisaExistirNoSistema(IClienteRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Cliente obj) {
		Cliente c = _repositorio.buscarPorID(obj.getId());
		
		if(c == null)
			return "Cliente "+ obj.getNome() +" não existe no sistema.";
		
		return null;
	}

}
