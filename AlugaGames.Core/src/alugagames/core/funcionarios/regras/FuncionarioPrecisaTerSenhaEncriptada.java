package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.shared.CriptografiaDES;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaTerSenhaEncriptada implements IRegra<Funcionario> {

	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioPrecisaTerSenhaEncriptada(IFuncionarioRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(Funcionario obj) {
		Funcionario f = _repositorio.buscarPorID(obj.getId());
		
		if(f == null)
			return "Não foi possível validar senha encriptada.";
		else{
			if(!f.getSenha().equals(obj.getSenha())){
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
