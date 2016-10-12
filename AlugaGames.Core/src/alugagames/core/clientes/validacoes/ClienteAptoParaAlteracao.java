package alugagames.core.clientes.validacoes;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.regras.ClientePrecisaExistirNoSistema;
import alugagames.core.clientes.regras.ClientePrecisaSerMaiorDe18Anos;
import alugagames.core.clientes.regras.ClientePrecisaTerCidadeValida;
import alugagames.core.clientes.regras.ClientePrecisaTerCpfUnicoAlt;
import alugagames.core.clientes.regras.ClientePrecisaTerCpfValido;
import alugagames.core.clientes.regras.ClientePrecisaTerEmailUnicoAlt;
import alugagames.core.clientes.regras.ClientePrecisaTerEmailValido;
import alugagames.core.clientes.regras.ClientePrecisaTerNomeValido;
import alugagames.core.clientes.regras.ClientePrecisaTerSenhaEncriptada;
import alugagames.core.clientes.regras.ClientePrecisaTerSenhaValida;
import alugagames.core.clientes.regras.ClientePrecisaTerSexoValido;
import alugagames.core.clientes.regras.ClientePrecisaTerTelefoneValido;
import alugagames.core.clientes.regras.ClientePrecisaTerUfValida;
import alugagames.core.clientes.repositorio.IClienteRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class ClienteAptoParaAlteracao extends Validacao<Cliente>{

	public ClienteAptoParaAlteracao(IClienteRepositorio repositorio) {
		adicionarRegra(new ClientePrecisaExistirNoSistema(repositorio));
		adicionarRegra(new ClientePrecisaTerNomeValido());
		adicionarRegra(new ClientePrecisaTerSenhaValida());
		adicionarRegra(new ClientePrecisaTerSenhaEncriptada(repositorio));
		adicionarRegra(new ClientePrecisaTerEmailValido());
		adicionarRegra(new ClientePrecisaTerEmailUnicoAlt(repositorio));
		adicionarRegra(new ClientePrecisaTerCpfValido());
		adicionarRegra(new ClientePrecisaTerCpfUnicoAlt(repositorio));
		adicionarRegra(new ClientePrecisaTerTelefoneValido());
		adicionarRegra(new ClientePrecisaTerSexoValido());
		adicionarRegra(new ClientePrecisaSerMaiorDe18Anos());
		adicionarRegra(new ClientePrecisaTerUfValida());
		adicionarRegra(new ClientePrecisaTerCidadeValida());
	}

}
