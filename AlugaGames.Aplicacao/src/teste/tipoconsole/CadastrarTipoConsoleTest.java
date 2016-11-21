package teste.tipoconsole;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.TipoConsoleAplicacao;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class CadastrarTipoConsoleTest {
	private static TipoConsoleAplicacao tipoConsoleAplicacao;
	private static TipoConsole tipoConsole;
	
	@BeforeClass
	public static void inicializar() {
		tipoConsoleAplicacao = new TipoConsoleAplicacao();
	}
	
	@Test
	public void cadastrarTipoConsoleComDadosValidos() {
		
		tipoConsole = new TipoConsole();
		tipoConsole.setNome("Nitendo");
		
		List<String> erros = tipoConsoleAplicacao.cadastrar(tipoConsole);
		Assert.assertTrue(erros.isEmpty());
	}
	
	@Test
	public void cadastrarTipoConsoleComDadosInvalidos() {
		TipoConsole tc = new TipoConsole();
		tc.setNome("X");
		
		List<String> erros = tipoConsoleAplicacao.cadastrar(tc);

		Assert.assertTrue(erros.contains("Nome deve ter ao menos 4 caracteres."));
	}
	
	
	@Test
	public void cadastrarTipoConsoleSemDados() {
		TipoConsole tc = new TipoConsole();
		List<String> erros = tipoConsoleAplicacao.cadastrar(tc);
		
		Assert.assertTrue(erros.contains("Nome não informado."));
	}
	
	@AfterClass
	public static void fecharConexao(){
		excluirTipoConsole();
		ConnectionManager.dispose();
	}
	
	private static void excluirTipoConsole(){
		ConnectionManager.beginTransaction();
		TipoConsoleRepositorio repositorio = new TipoConsoleRepositorio();
		TipoConsole tc = repositorio.buscarPorID(tipoConsole.getId());
		repositorio.excluir(tc);
		ConnectionManager.commit();
	}
}
