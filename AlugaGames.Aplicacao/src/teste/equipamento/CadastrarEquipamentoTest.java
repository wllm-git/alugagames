package teste.equipamento;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.EquipamentoAplicacao;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.TipoEquipamento;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.repositorio.EquipamentoRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class CadastrarEquipamentoTest {
	private static EquipamentoAplicacao equipamentoAplicacao;
	private static Equipamento equipamento;
	private static TipoConsole tipoConsole;
	
	@BeforeClass
	public static void inicializar() {
		tipoConsole = new TipoConsole();
		tipoConsole.setNome("PS4 Teste");
		
		ConnectionManager.beginTransaction();
		new TipoConsoleRepositorio().adicionar(tipoConsole);
		ConnectionManager.commit();
		
		equipamentoAplicacao = new EquipamentoAplicacao();
	}
	
	@Test
	public void cadastrarEquipamentoComDadosValidos() {
		
		equipamento = new Equipamento();
		equipamento.setTipoEquipamento(TipoEquipamento.Controle);
		equipamento.setNumeroSerie("345684");
		equipamento.setPreco(12.15f);
		equipamento.setTipoConsole(tipoConsole);
		
		List<String> erros = equipamentoAplicacao.cadastrar(equipamento);
		Assert.assertTrue(erros.isEmpty());
	}
	
	@Test
	public void cadastrarEquipamentoComDadosInvalidos() {
		Equipamento e = new Equipamento();
		
		e.setNumeroSerie("123");
		e.setPreco(-2.15f);
		TipoConsole tc = new TipoConsole();
		tc.setNome("Xbox One Teste");
		e.setTipoConsole(tc);
		
		List<String> erros = equipamentoAplicacao.cadastrar(e);

		Assert.assertTrue(erros.contains("Número de série deve ter ao menos 4 caracteres."));
		Assert.assertTrue(erros.contains("Preço inválido."));
		Assert.assertTrue(erros.contains("Tipo de console "+ tc.getNome() +" não existe no sistema."));
	}
	
	
	@Test
	public void cadastrarEquipamentoSemDados() {
		Equipamento e = new Equipamento();
		List<String> erros = equipamentoAplicacao.cadastrar(e);
		
		Assert.assertTrue(erros.contains("Número de série não informado."));
		Assert.assertTrue(erros.contains("Preço inválido."));
		Assert.assertTrue(erros.contains("Tipo de console não informado."));
	}
		
	@AfterClass
	public static void fecharConexao(){
		excluirEquipamento();
		ConnectionManager.dispose();
	}
	
	private static void excluirEquipamento(){
		ConnectionManager.beginTransaction();
		EquipamentoRepositorio repositorio = new EquipamentoRepositorio();
		Equipamento e = repositorio.buscarPorID(equipamento.getId());
		repositorio.excluir(e);
		ConnectionManager.commit();
	}
}
