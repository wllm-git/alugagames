package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.AluguelPrecisaExistirNoSistema;
import alugagames.core.alugueis.regras.AluguelPrecisaTerAtendenteConfirmacaoValido;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.shared.validacoesregras.Validacao;

public class AluguelAptoParaSerConfirmado extends Validacao<Aluguel>{
	
	public AluguelAptoParaSerConfirmado(IAluguelRepositorio repositorio, FuncionarioServico atendenteServico){
		
		adicionarRegra(new AluguelPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new AluguelPrecisaTerAtendenteConfirmacaoValido(atendenteServico));
		
	}
}
