package teste.funcionario;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.FuncionarioAplicacao;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class CadastrarFuncionarioTest {
	private static FuncionarioAplicacao funcionarioAplicacao;
	private static Funcionario funcionario;
	
	@BeforeClass
	public static void inicializar() {
		funcionarioAplicacao = new FuncionarioAplicacao();
	}
	
	@Test
	public void cadastrarFuncionarioComDadosValidos() {
		
		funcionario = new Funcionario();
		
		funcionario.setNome("Novo Cliente da Silva");
		funcionario.setCpf("90693638362");
		funcionario.setDataNascimento(new Date(90,10,10));
		funcionario.setEmail("funcionario@email.com");
		funcionario.setSenha("123456");
		funcionario.setSexo('M');
		funcionario.setTelefone("98745635");
		funcionario.setFuncao(Funcao.Atendente);
		
		List<String> erros = funcionarioAplicacao.cadastrar(funcionario);
		Assert.assertTrue(erros.isEmpty());
	}
	
	@Test
	public void cadastrarFuncionarioComDadosInvalidos() {
		Funcionario f = new Funcionario();
		
		f.setNome("No");
		f.setCpf("99999999999");
		f.setDataNascimento(new Date());
		f.setEmail("email@email");
		f.setSexo('A');
		f.setTelefone("5635");
		
		List<String> erros = funcionarioAplicacao.cadastrar(f);

		Assert.assertTrue(erros.contains("Nome precisa ter ao menos 3 caracteres."));
		Assert.assertTrue(erros.contains("CPF inv�lido."));
		Assert.assertTrue(erros.contains("Funcion�rio n�o pode ser menor de idade."));
		Assert.assertTrue(erros.contains("E-mail inv�lido."));
		Assert.assertTrue(erros.contains("Telefone inv�lido."));
		Assert.assertTrue(erros.contains("Sexo inv�lido."));
	}
	
	
	@Test
	public void cadastrarFuncionarioSemDados() {
		Funcionario f = new Funcionario();
		List<String> erros = funcionarioAplicacao.cadastrar(f);
		
		Assert.assertTrue(erros.contains("Nome n�o informado."));
		Assert.assertTrue(erros.contains("CPF n�o informado."));
		Assert.assertTrue(erros.contains("Data de nascimento n�o informada."));
		Assert.assertTrue(erros.contains("E-mail n�o informado."));
		Assert.assertTrue(erros.contains("Senha n�o informada."));
		Assert.assertTrue(erros.contains("Sexo inv�lido."));
	}
	
	@AfterClass
	public static void fecharConexao(){
		excluirFuncionario();
		ConnectionManager.dispose();
	}
	
	private static void excluirFuncionario(){
		ConnectionManager.beginTransaction();
		FuncionarioRepositorio repositorio = new FuncionarioRepositorio();
		Funcionario f = repositorio.buscarPorID(funcionario.getId());
		repositorio.excluir(f);
		ConnectionManager.commit();
	}
}
