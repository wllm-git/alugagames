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
	private static Cliente clienteDup;
	
	@BeforeClass
	public static void inicializar() {
		clienteDup = new Cliente();
		clienteDup.setCpf("54433712400");
		clienteDup.setEmail("email@email.com.br");
		
		
		ConnectionManager.beginTransaction();
		ClienteRepositorio repositorio = new ClienteRepositorio();
		repositorio.adicionar(clienteDup);
		ConnectionManager.commit();
		
		
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
		Assert.assertTrue(erros.contains("CPF inválido."));
		Assert.assertTrue(erros.contains("Cliente não pode ser menor de idade."));
		Assert.assertTrue(erros.contains("E-mail inválido."));
		Assert.assertTrue(erros.contains("Telefone inválido."));
		Assert.assertTrue(erros.contains("Sexo inválido."));
	}
	
	
	@Test
	public void cadastrarClienteSemDados() {
		Cliente c = new Cliente();
		List<String> erros = clienteAplicacao.adicionarCliente(c);
		
		Assert.assertTrue(erros.contains("Nome não informado."));
		Assert.assertTrue(erros.contains("CPF não informado."));
		Assert.assertTrue(erros.contains("Data de nascimento não informada."));
		Assert.assertTrue(erros.contains("E-mail não informado."));
		Assert.assertTrue(erros.contains("Senha não informada."));
		Assert.assertTrue(erros.contains("Sexo inválido."));
		Assert.assertTrue(erros.contains("Cidade não informada."));
		Assert.assertTrue(erros.contains("UF não informada."));
	}
	
	@Test
	public void cadastrarClienteComEmailDuplicado() {
		Cliente c = new Cliente();
		
		c.setEmail("email@email.com.br");
		
		List<String> erros = clienteAplicacao.adicionarCliente(c);

		Assert.assertTrue(erros.contains("E-mail já está em uso."));
	}
	
	@Test
	public void cadastrarClienteComCPFDuplicado() {
		Cliente c = new Cliente();
		
		c.setCpf("54433712400");
		
		List<String> erros = clienteAplicacao.adicionarCliente(c);

		Assert.assertTrue(erros.contains("CPF já está em uso."));
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
		c = repositorio.buscarPorID(clienteDup.getId());
		repositorio.excluir(c);
		ConnectionManager.commit();
	}
}
