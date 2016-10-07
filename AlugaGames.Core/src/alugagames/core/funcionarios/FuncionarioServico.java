package alugagames.core.funcionarios;

import java.util.List;
import java.util.UUID;

import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaAlteracao;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaCadastro;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaSerInativado;

public class FuncionarioServico {
	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioServico(IFuncionarioRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public Funcionario buscarPorId(UUID id){
		return _repositorio.buscarPorID(id);
	}
	
	public List<String> adicionarFuncionario(Funcionario funcionario) {
		
		List<String> erros = new FuncionarioAptoParaCadastro(_repositorio).validar(funcionario);
		if(erros.isEmpty())
			_repositorio.adicionar(funcionario);
		
		return erros;
	}

	public List<String> atualizarFuncionario(Funcionario funcionario) {

		List<String> erros = new FuncionarioAptoParaAlteracao(_repositorio).validar(funcionario);
		if(erros.isEmpty())
			_repositorio.alterar(funcionario);
		
		return erros;
	}
	
	public List<String> inativarFuncionario(Funcionario funcionario, UUID idFuncionarioLogado){
		
		List<String> erros = new FuncionarioAptoParaSerInativado(_repositorio, idFuncionarioLogado).validar(funcionario);
		if(!erros.isEmpty())
			return erros;
		
		funcionario.setAtivo(false);
		_repositorio.alterar(funcionario);
		
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
