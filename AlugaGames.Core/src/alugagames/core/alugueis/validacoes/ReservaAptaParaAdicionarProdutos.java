package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.ReservaPrecisaTerStatusValidoParaAddProdutos;
import alugagames.core.shared.validacoesregras.Validacao;

public class ReservaAptaParaAdicionarProdutos extends Validacao<Aluguel>{
	
	public ReservaAptaParaAdicionarProdutos(){
		adicionarRegra(new ReservaPrecisaTerStatusValidoParaAddProdutos());
	}
}
