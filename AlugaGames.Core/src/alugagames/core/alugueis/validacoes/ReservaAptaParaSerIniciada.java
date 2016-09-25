package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.ReservaPrecisaTerClienteValido;
import alugagames.core.shared.validacoesregras.Validacao;

public class ReservaAptaParaSerIniciada extends Validacao<Aluguel>{
	public ReservaAptaParaSerIniciada(){
		adicionarRegra(new ReservaPrecisaTerClienteValido());
	}
}
