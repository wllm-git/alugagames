package alugagames.core.clientes.validacoes;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.regras.ClientePrecisaSerMaiorDe18Anos;
import alugagames.core.clientes.regras.ClientePrecisaTerCidadeValida;
import alugagames.core.clientes.regras.ClientePrecisaTerCpfUnico;
import alugagames.core.clientes.regras.ClientePrecisaTerCpfValido;
import alugagames.core.clientes.regras.ClientePrecisaTerEmailUnico;
import alugagames.core.clientes.regras.ClientePrecisaTerEmailValido;
import alugagames.core.clientes.regras.ClientePrecisaTerNomeValido;
import alugagames.core.clientes.regras.ClientePrecisaTerSenhaValida;
import alugagames.core.clientes.regras.ClientePrecisaTerSexoValido;
import alugagames.core.clientes.regras.ClientePrecisaTerTelefoneValido;
import alugagames.core.clientes.regras.ClientePrecisaTerUfValida;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class ClienteAptoParaCadastro extends Validacao<Cliente>{

	public ClienteAptoParaCadastro(IClienteRepositorio repositorio) {
		adicionarRegra(new ClientePrecisaTerNomeValido());
		adicionarRegra(new ClientePrecisaTerSenhaValida());
		adicionarRegra(new ClientePrecisaTerEmailValido());
		adicionarRegra(new ClientePrecisaTerEmailUnico(repositorio));
		adicionarRegra(new ClientePrecisaTerCpfValido());
		adicionarRegra(new ClientePrecisaTerCpfUnico(repositorio));
		adicionarRegra(new ClientePrecisaTerTelefoneValido());
		adicionarRegra(new ClientePrecisaTerSexoValido());
		adicionarRegra(new ClientePrecisaSerMaiorDe18Anos());
		adicionarRegra(new ClientePrecisaTerUfValida());
		adicionarRegra(new ClientePrecisaTerCidadeValida());
	}
	
}
