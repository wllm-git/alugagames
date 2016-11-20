package teste.os;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import alugagames.aplicacao.OrdemServicoAplicacao;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.os.OrdemServicoItem;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.config.ConnectionManager;

public class AbrirOSInternaTest {
	private static OrdemServicoAplicacao ordemServicoAplicacao;
	private static Funcionario atendenteAtivo;
	private static Funcionario atendenteInativo;

	@BeforeClass
	public static void inicializar() {
		
		atendenteAtivo= new Funcionario();
		atendenteAtivo.setFuncao(Funcao.Atendente);
		atendenteAtivo.setAtivo(true);
		
		atendenteInativo= new Funcionario();
		atendenteInativo.setFuncao(Funcao.Atendente);
		atendenteInativo.setAtivo(false);
		
		ConnectionManager.beginTransaction();
		new FuncionarioRepositorio().adicionar(atendenteAtivo);
		new FuncionarioRepositorio().adicionar(atendenteInativo);
		ConnectionManager.commit();

		ordemServicoAplicacao = new OrdemServicoAplicacao();
	}
	
	@Test
	public void abrirOSInternaOK() {
		try {
			List<String> erros = ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, null);

			if(!erros.isEmpty())
				Assert.fail();

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void abrirOSInternaSemItens() {
		try {
			ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, new ArrayList<OrdemServicoItem>());
			
			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}

	}
	
	@Test
	public void abrirOSInternaComItemInativo() {
		try {
			ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, new ArrayList<OrdemServicoItem>());

			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}

	}
	
	@Test
	public void abrirOSInternaComItemSemAvaria() {
		try {
			ordemServicoAplicacao.abrirOSInterna(atendenteAtivo, new ArrayList<OrdemServicoItem>());

			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}
	}
	
	@Test
	public void abrirOSInternaSemAtendente() {
		try {
			ordemServicoAplicacao.abrirOSInterna(null, new ArrayList<OrdemServicoItem>());

			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}
	}
	
	@Test
	public void abrirOSInternaComAtendenteNaoCadastrado() {
		try {
			ordemServicoAplicacao.abrirOSInterna(new Funcionario(), new ArrayList<OrdemServicoItem>());

			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}
	}
	
	@Test
	public void abrirOSInternaComAtendenteInativo() {
		try {
			ordemServicoAplicacao.abrirOSInterna(atendenteInativo, new ArrayList<OrdemServicoItem>());

			Assert.fail();
		} catch (RuntimeException e) {
			// OK
		}
	}
	
	@AfterClass
	public static void fecharConexao(){
		ConnectionManager.dispose();
	}
}
