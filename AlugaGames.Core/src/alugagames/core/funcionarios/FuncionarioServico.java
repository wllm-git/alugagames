package alugagames.core.funcionarios;

import java.util.List;
import java.util.UUID;

import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaAlteracao;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaCadastro;

public class FuncionarioServico {
	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioServico(IFuncionarioRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public Funcionario buscarPorId(UUID id){
		return _repositorio.buscarPorID(id);
	}
	
	public List<String> adicionarFuncionario(Funcionario funcionario) {
		
		List<String> erros = new FuncionarioAptoParaCadastro().validar(funcionario);
		if(erros.isEmpty())
			_repositorio.adicionar(funcionario);
		
		return erros;
	}

	public List<String> atualizarFuncionario(Funcionario funcionario) {

		List<String> erros = new FuncionarioAptoParaAlteracao().validar(funcionario);
		if(erros.isEmpty())
			_repositorio.adicionar(funcionario);
		
		return erros;
	}
	
	public Funcionario logar(String email, String senha) throws Exception {
		Funcionario funcionario = _repositorio.buscarPorEmail(email);
		
		if(funcionario == null || !funcionario.getSenha().equals(senha))
			throw new Exception("e-mail e/ou senha inválidos.");
		else if(!funcionario.isAtivo())
			throw new Exception("funcionário " + funcionario.getNome() + " está inativo.");
		
		return funcionario;
	}
}
