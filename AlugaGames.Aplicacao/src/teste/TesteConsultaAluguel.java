package teste;

import alugagames.aplicacao.AluguelAplicacao;
import alugagames.core.alugueis.Aluguel;

public class TesteConsultaAluguel {
	public static void main(String[] args) {

		try{
			
			AluguelAplicacao ap = new AluguelAplicacao();
			
			Aluguel a2 = ap.buscarReservaPorCodigo(1);
			System.out.println(a2.getStatus());
			
			Aluguel a3 = ap.buscarAluguelPorCodigo(1);
			if(a3 == null)
				System.out.println("Não encontrado.");
			else
				System.out.println(a3.getStatus());
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
