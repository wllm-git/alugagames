package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.ReservaPrecisaTerClienteValido;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.shared.validacoesregras.Validacao;

public class ReservaAptaParaSerIniciada extends Validacao<Aluguel>{
	public ReservaAptaParaSerIniciada(ClienteServico clienteServico){
		adicionarRegra(new ReservaPrecisaTerClienteValido(clienteServico));
	}
}
