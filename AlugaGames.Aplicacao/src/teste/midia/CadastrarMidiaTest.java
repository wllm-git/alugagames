package teste.midia;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.MidiaAplicacao;
import alugagames.core.jogos.Jogo;
import alugagames.core.midias.Midia;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.JogoRepositorio;
import alugagames.repositorio.MidiaRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class CadastrarMidiaTest {
	private static MidiaAplicacao midiaAplicacao;
	private static Midia midia;
	private static TipoConsole tipoConsole;
	private static Jogo jogo;
	
	@BeforeClass
	public static void inicializar() {
		tipoConsole = new TipoConsole();
		tipoConsole.setNome("PS4 Teste");
		
		jogo = new Jogo();
		
		ConnectionManager.beginTransaction();
		new TipoConsoleRepositorio().adicionar(tipoConsole);
		new JogoRepositorio().adicionar(jogo);
		ConnectionManager.commit();
		
		midiaAplicacao = new MidiaAplicacao();
	}
	
	@Test
	public void cadastrarMidiaComDadosValidos() {
		
		midia = new Midia();
		
		midia.setNumeroSerie("954455");
		midia.setPreco(12.15f);
		midia.setTipoConsole(tipoConsole);
		midia.setJogo(jogo);
		
		List<String> erros = midiaAplicacao.cadastrar(midia);
		Assert.assertTrue(erros.isEmpty());
	}
	
	@Test
	public void cadastrarMidiaComDadosInvalidos() {
		Midia m = new Midia();
		
		m.setNumeroSerie("41");
		m.setPreco(-2.15f);
		TipoConsole tc = new TipoConsole();
		tc.setNome("Xbox One Teste");
		m.setTipoConsole(tc);
		m.setJogo(new Jogo());
		m.getJogo().setNome("Teste");
		
		List<String> erros = midiaAplicacao.cadastrar(m);

		Assert.assertTrue(erros.contains("Número de série deve ter ao menos 4 caracteres."));
		Assert.assertTrue(erros.contains("Preço inválido."));
		Assert.assertTrue(erros.contains("Tipo de console "+ tc.getNome() +" não existe no sistema."));
		Assert.assertTrue(erros.contains("Jogo " + m.getJogo().getNome() +" não existe no sistema."));
	}
	
	
	@Test
	public void cadastrarMidiaSemDados() {
		Midia m = new Midia();
		List<String> erros = midiaAplicacao.cadastrar(m);
		
		Assert.assertTrue(erros.contains("Número de série não informado."));
		Assert.assertTrue(erros.contains("Preço inválido."));
		Assert.assertTrue(erros.contains("Tipo de console não informado."));
		Assert.assertTrue(erros.contains("Jogo não informado."));
	}
		
	@AfterClass
	public static void fecharConexao(){
		excluirMidia();
		ConnectionManager.dispose();
	}
	
	private static void excluirMidia(){
		ConnectionManager.beginTransaction();
		MidiaRepositorio repositorio = new MidiaRepositorio();
		Midia m = repositorio.buscarPorID(midia.getId());
		repositorio.excluir(m);
		ConnectionManager.commit();
	}
}
