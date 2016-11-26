package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.AluguelPrecisaTerDataFimValida;
import alugagames.core.alugueis.regras.AluguelPrecisaTerDataInicioValida;
import alugagames.core.alugueis.regras.ReservaPrecisaTerClienteValido;
import alugagames.core.alugueis.regras.ReservaPrecisaTerItensDisponiveis;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.shared.validacoesregras.Validacao;

public class ReservaAptaParaSerConfirmada extends Validacao<Aluguel>{
	public ReservaAptaParaSerConfirmada(ClienteServico clienteServico){
		adicionarRegra(new ReservaPrecisaTerClienteValido(clienteServico));
		adicionarRegra(new AluguelPrecisaTerDataInicioValida());
		adicionarRegra(new AluguelPrecisaTerDataFimValida());
		adicionarRegra(new ReservaPrecisaTerItensDisponiveis());
	}
}
