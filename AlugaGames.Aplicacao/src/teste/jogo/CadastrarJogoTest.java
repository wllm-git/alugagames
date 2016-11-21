package teste.jogo;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.JogoAplicacao;
import alugagames.core.jogos.Categoria;
import alugagames.core.jogos.Jogo;
import alugagames.repositorio.JogoRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class CadastrarJogoTest {
	private static JogoAplicacao jogoAplicacao;
	private static Jogo jogo;
	
	@BeforeClass
	public static void inicializar() {
		jogoAplicacao = new JogoAplicacao();
	}
	
	@Test
	public void cadastrarJogoComDadosValidos() {
		
		jogo = new Jogo();
		jogo.setNome("Jogo Ninja");
		jogo.setAnoLancamento(new Date(99, 1, 1));
		jogo.setCategoria(Categoria.Aventura);
		
		List<String> erros = jogoAplicacao.cadastrar(jogo);
		Assert.assertTrue(erros.isEmpty());
	}
	
	@Test
	public void cadastrarJogoComDadosInvalidos() {
		Jogo j = new Jogo();
		
		j.setNome("J");
		
		List<String> erros = jogoAplicacao.cadastrar(j);

		Assert.assertTrue(erros.contains("Nome deve ter ao menos 6 caracteres."));
		Assert.assertTrue(erros.contains("Categoria não foi informada."));
		Assert.assertTrue(erros.contains("Ano de lançamento não informado."));
	}
	
	
	@Test
	public void cadastrarJogoSemDados() {
		Jogo r = new Jogo();
		List<String> erros = jogoAplicacao.cadastrar(r);
		
		Assert.assertTrue(erros.contains("Nome não informado."));
		Assert.assertTrue(erros.contains("Categoria não foi informada."));
		Assert.assertTrue(erros.contains("Ano de lançamento não informado."));
	}
		
	@AfterClass
	public static void fecharConexao(){
		excluirJogo();
		ConnectionManager.dispose();
	}
	
	private static void excluirJogo(){
		ConnectionManager.beginTransaction();
		JogoRepositorio repositorio = new JogoRepositorio();
		Jogo j = repositorio.buscarPorID(jogo.getId());
		repositorio.excluir(j);
		ConnectionManager.commit();
	}
}
