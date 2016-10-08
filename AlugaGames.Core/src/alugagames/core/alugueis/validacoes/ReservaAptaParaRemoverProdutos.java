package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.ReservaPrecisaTerStatusValidoParaAddProdutos;
import alugagames.core.shared.validacoesregras.Validacao;

public class ReservaAptaParaRemoverProdutos extends Validacao<Aluguel>{
	
	public ReservaAptaParaRemoverProdutos(){
		adicionarRegra(new ReservaPrecisaTerStatusValidoParaAddProdutos());
	}
}
