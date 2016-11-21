package teste.console;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.ConsoleAplicacao;
import alugagames.core.consoles.Console;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.ConsoleRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class CadastrarConsoleTest {
	private static ConsoleAplicacao consoleAplicacao;
	private static Console console;
	private static TipoConsole tipoConsole;
	
	@BeforeClass
	public static void inicializar() {
		tipoConsole = new TipoConsole();
		tipoConsole.setNome("PS4 Teste");
		
		ConnectionManager.beginTransaction();
		new TipoConsoleRepositorio().adicionar(tipoConsole);
		ConnectionManager.commit();
		
		consoleAplicacao = new ConsoleAplicacao();
	}
	
	@Test
	public void cadastrarConsoleComDadosValidos() {
		
		console = new Console();
		
		console.setAno(new Date(106, 1, 1));
		console.setNumeroSerie("123456");
		console.setPreco(12.15f);
		console.setTipoConsole(tipoConsole);
		
		List<String> erros = consoleAplicacao.cadastrar(console);
		Assert.assertTrue(erros.isEmpty());
	}
	
	@Test
	public void cadastrarConsoleComDadosInvalidos() {
		Console c = new Console();
		
		c.setNumeroSerie("123");
		c.setPreco(-2.15f);
		TipoConsole tc = new TipoConsole();
		tc.setNome("Xbox One Teste");
		c.setTipoConsole(tc);
		
		List<String> erros = consoleAplicacao.cadastrar(c);

		Assert.assertTrue(erros.contains("Número de série deve ter ao menos 4 caracteres."));
		Assert.assertTrue(erros.contains("Preço inválido."));
		Assert.assertTrue(erros.contains("Tipo de console "+ tc.getNome() +" não existe no sistema."));
	}
	
	
	@Test
	public void cadastrarConsoleSemDados() {
		Console c = new Console();
		List<String> erros = consoleAplicacao.cadastrar(c);
		
		Assert.assertTrue(erros.contains("Número de série não informado."));
		Assert.assertTrue(erros.contains("Preço inválido."));
		Assert.assertTrue(erros.contains("Tipo de console não informado."));
	}
	
	@Test
	public void cadastrarConsoleComNumeroSerieCaracterEspecial() {
		Console c = new Console();
		c.setNumeroSerie("123456@");
		List<String> erros = consoleAplicacao.cadastrar(c);
		
		Assert.assertTrue(erros.contains("Número de série deve conter apenas letras e/ou números."));
	}
	
	@AfterClass
	public static void fecharConexao(){
		excluirConsole();
		ConnectionManager.dispose();
	}
	
	private static void excluirConsole(){
		ConnectionManager.beginTransaction();
		ConsoleRepositorio repositorio = new ConsoleRepositorio();
		Console c = repositorio.buscarPorID(console.getId());
		repositorio.excluir(c);
		ConnectionManager.commit();
	}
}
