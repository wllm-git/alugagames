package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.AluguelPrecisaExistirNoSistema;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class AluguelAptoParaSerConfirmado extends Validacao<Aluguel>{
	public AluguelAptoParaSerConfirmado(IAluguelRepositorio repositorio){
		adicionarRegra(new AluguelPrecisaExistirNoSistema(repositorio));
	}
}
