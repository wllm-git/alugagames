package alugagames.core.orcamentos.validacoes;

import alugagames.core.clientes.ClienteServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.regras.OrcamentoPrecisaTerClienteValido;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrcamentoAptoParaIniciar extends Validacao<Orcamento>{

	public OrcamentoAptoParaIniciar(ClienteServico clienteServico) {
		adicionarRegra(new OrcamentoPrecisaTerClienteValido(clienteServico));
	}

}
