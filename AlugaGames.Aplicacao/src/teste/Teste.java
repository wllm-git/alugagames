package teste;
import java.util.Date;
import java.util.UUID;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.regras.FuncionarioPrecisaSerMaiorDe18Anos;
import alugagames.core.shared.CriptografiaDES;
import alugagames.repositorio.FuncionarioRepositorio;

public class Teste {

	public static void main(String[] args) {
		
		try {

			UUID id = UUID.fromString("42aeaf89-44ba-44fc-a778-f2f97f474485");
			Funcionario f = new Funcionario();
			f.setId(id);
			
//			int qtdAluguelEmAndamento = new FuncionarioRepositorio().getQtdDeAlugueisEmAndamento(f);
//			System.out.println(qtdAluguelEmAndamento);
			
//			f.setDataNascimento(new Date(99,9, 1));
//			String s = new FuncionarioPrecisaSerMaiorDe18Anos().validar(f);
//			
//			System.out.println(s);
//			System.out.println(f.getDataNascimento());
			
			String t = "agora vai";
			String encriptado = CriptografiaDES.encriptar(t);
			System.out.println(encriptado);
			String decriptado = CriptografiaDES.decriptar(encriptado);
			System.out.println(decriptado);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
