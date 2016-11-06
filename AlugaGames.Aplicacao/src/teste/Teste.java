package teste;
import java.util.Date;
import java.util.UUID;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.AluguelPrecisaTerDataInicioValida;
import alugagames.core.consoles.Console;
import alugagames.core.equipamentos.TipoEquipamento;
import alugagames.core.shared.FuncoesGerais;
import alugagames.repositorio.ConsoleRepositorio;

public class Teste {

	public static void main(String[] args) {
		
		try {

			UUID id = UUID.fromString("b5f35643-1bdd-432d-8e47-3329935f428b");
			Console f = new Console();
			f.setId(id);
			//Console c = new ConsoleRepositorio().buscarPorID(id);
			
			//===========================================================================================================			
//			int qtdAluguelEmAndamento = new FuncionarioRepositorio().getQtdDeAlugueisEmAndamento(f);
//			System.out.println(qtdAluguelEmAndamento);
//			
//			f.setDataNascimento(new Date(99,9, 1));
//			String s = new FuncionarioPrecisaSerMaiorDe18Anos().validar(f);
//			
//			System.out.println(s);
//			System.out.println(f.getDataNascimento());
			//===========================================================================================================
//			String t = "agora vai";
//			String encriptado = CriptografiaDES.encriptar(t);
//			System.out.println(encriptado);
//			String decriptado = CriptografiaDES.decriptar(encriptado);
//			System.out.println(decriptado);
			//===========================================================================================================			
			System.out.println(TipoEquipamento.Controle.toString() == "Controle");
			
			System.out.println(FuncoesGerais.emailValido("willia.m@gmail.vv"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
