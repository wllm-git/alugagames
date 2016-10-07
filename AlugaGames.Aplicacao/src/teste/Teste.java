package teste;
import java.util.UUID;

import alugagames.core.funcionarios.Funcionario;
import alugagames.repositorio.FuncionarioRepositorio;

public class Teste {

	public static void main(String[] args) {
		
		try {

			UUID id = UUID.fromString("42aeaf89-44ba-44fc-a778-f2f97f474485");
			Funcionario f = new Funcionario();
			f.setId(id);
			int qtdAluguelEmAndamento = new FuncionarioRepositorio().getQtdDeAlugueisEmAndamento(f);
			
			System.out.println(qtdAluguelEmAndamento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
