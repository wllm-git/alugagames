package alugagames.core.clientes.regras;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.CriptografiaDES;
import alugagames.core.shared.validacoesregras.IRegra;

public class ClientePrecisaTerSenhaEncriptada implements IRegra<Cliente> {

	private IClienteRepositorio _repositorio;
	
	public ClientePrecisaTerSenhaEncriptada(IClienteRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Cliente obj) {
		Cliente c = _repositorio.buscarPorID(obj.getId());
		
		if(c == null)
			return "Não foi possível validar senha encriptada.";
		else{
			if(!c.getSenha().equals(obj.getSenha())){
				if(obj.getSenha() != null && !obj.getSenha().isEmpty()){
					try {
						obj.setSenha(CriptografiaDES.encriptar(obj.getSenha()));
					} catch (Exception e) {
						return "Não foi possível encriptar a senha";
					}
				}
			}
		}
		
		return null;
	}

}
