package teste.cliente;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.ClienteAplicacao;
import alugagames.core.clientes.Cliente;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class CadastrarClienteTest {
	private static ClienteAplicacao clienteAplicacao;
	private static Cliente cliente;
	
	@BeforeClass
	public static void inicializar() {
		clienteAplicacao = new ClienteAplicacao();
	}
	
	@Test
	public void cadastrarClienteComDadosValidos() {
		
		cliente = new Cliente();
		
		cliente.setNome("Novo Cliente da Silva");
		cliente.setCpf("90693638362");
		cliente.setRg("0123456");
		cliente.setDataNascimento(new Date(90,10,10));
		cliente.setEmail("email@email.com");
		cliente.setSenha("123456");
		cliente.setSexo('M');
		cliente.setTelefone("98745635");
		cliente.setCidade("Recife");
		cliente.setUf("PE");
		
		List<String> erros = clienteAplicacao.adicionarCliente(cliente);
		Assert.assertTrue(erros.isEmpty());
	}
	
	@Test
	public void cadastrarClienteComDadosInvalidos() {
		Cliente c = new Cliente();
		
		c.setNome("No");
		c.setCpf("99999999999");
		c.setDataNascimento(new Date());
		c.setEmail("email@email");
		c.setSexo('A');
		c.setTelefone("5635");
		
		List<String> erros = clienteAplicacao.adicionarCliente(c);

		Assert.assertTrue(erros.contains("Nome precisa ter ao menos 3 caracteres."));
		Assert.assertTrue(erros.contains("CPF inv�lido."));
		Assert.assertTrue(erros.contains("Cliente n�o pode ser menor de idade."));
		Assert.assertTrue(erros.contains("E-mail inv�lido."));
		Assert.assertTrue(erros.contains("Telefone inv�lido."));
		Assert.assertTrue(erros.contains("Sexo inv�lido."));
	}
	
	
	@Test
	public void cadastrarClienteSemDados() {
		Cliente c = new Cliente();
		List<String> erros = clienteAplicacao.adicionarCliente(c);
		
		Assert.assertTrue(erros.contains("Nome n�o informado."));
		Assert.assertTrue(erros.contains("CPF n�o informado."));
		Assert.assertTrue(erros.contains("Data de nascimento n�o informada."));
		Assert.assertTrue(erros.contains("E-mail n�o informado."));
		Assert.assertTrue(erros.contains("Senha n�o informada."));
		Assert.assertTrue(erros.contains("Sexo inv�lido."));
		Assert.assertTrue(erros.contains("Cidade n�o informada."));
		Assert.assertTrue(erros.contains("UF n�o informada."));
	}
	
	@AfterClass
	public static void fecharConexao(){
		excluirCliente();
		ConnectionManager.dispose();
	}
	
	private static void excluirCliente(){
		ConnectionManager.beginTransaction();
		ClienteRepositorio repositorio = new ClienteRepositorio();
		Cliente c = repositorio.buscarPorID(cliente.getId());
		repositorio.excluir(c);
		ConnectionManager.commit();
	}
}
