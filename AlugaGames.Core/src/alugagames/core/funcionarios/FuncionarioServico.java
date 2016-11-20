package alugagames.core.funcionarios;

import java.util.List;
import java.util.UUID;

import alugagames.core.funcionarios.repositorio.IFuncionarioRepositorio;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaAlteracao;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaCadastro;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaSerAtivado;
import alugagames.core.funcionarios.validacoes.FuncionarioAptoParaSerInativado;
import alugagames.core.shared.CriptografiaDES;
import alugagames.core.shared.ServicoBase;

public class FuncionarioServico extends ServicoBase<Funcionario>{
	private IFuncionarioRepositorio _repositorio;
	
	public FuncionarioServico(IFuncionarioRepositorio repositorio){
		super(repositorio);
		_repositorio = repositorio;
	}
		
	public List<String> adicionarFuncionario(Funcionario funcionario) {
		
		List<String> erros = new FuncionarioAptoParaCadastro(_repositorio).validar(funcionario);
		if(erros.isEmpty()){
			funcionario.setSenha(CriptografiaDES.encriptar(funcionario.getSenha()));
			_repositorio.adicionar(funcionario);
		}
			
		
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
	
	public List<String> ativarFuncionario(Funcionario funcionario){
		
		List<String> erros = new FuncionarioAptoParaSerAtivado(_repositorio).validar(funcionario);
		if(!erros.isEmpty())
			return erros;
		
		funcionario.setAtivo(true);
		_repositorio.alterar(funcionario);
		
		return erros;
	}
	
	public Funcionario buscarPorEmail(String email){
		return _repositorio.buscarPorEmail(email);
	}
	
	public Funcionario logar(String email, String senha) throws Exception {
		Funcionario funcionario = _repositorio.buscarPorEmail(email);
		
		if(funcionario == null)
			throw new Exception("e-mail e/ou senha inválidos.");
		else{
			String senhaD = CriptografiaDES.decriptar(funcionario.getSenha());
			
			if(!senhaD.equals(senha))
				throw new Exception("e-mail e/ou senha inválidos.");
			else if(!funcionario.isAtivo())
				throw new Exception("funcionário " + funcionario.getNome() + " está inativo.");
		}
		
		return funcionario;
	}

	public void excluir(Funcionario funcionarioSelecionado) {
		
		_repositorio.excluir(funcionarioSelecionado);
		
	}

	public List<Funcionario> buscarPorNome(String nome) {
		
		return _repositorio.buscarPorNome(nome);
	}

	public Funcionario bucarPorCpf(String cpf) {
		
		return _repositorio.buscarPorCpf(cpf);
	}
}
