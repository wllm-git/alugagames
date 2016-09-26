package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.ReservaPrecisaTerItensDisponiveis;
import alugagames.core.shared.validacoesregras.Validacao;

public class ReservaAptaParaSerConfirmada extends Validacao<Aluguel>{
	public ReservaAptaParaSerConfirmada(){
		adicionarRegra(new ReservaPrecisaTerItensDisponiveis());
	}
}
