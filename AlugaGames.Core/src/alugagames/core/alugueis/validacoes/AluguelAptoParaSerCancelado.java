package alugagames.core.alugueis.validacoes;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.alugueis.regras.AluguelPrecisaExistirNoSistema;
import alugagames.core.alugueis.regras.AluguelSituacaoDeCancelamentoValida;
import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class AluguelAptoParaSerCancelado extends Validacao<Aluguel>{
	public AluguelAptoParaSerCancelado(IAluguelRepositorio repositorio){
		adicionarRegra(new AluguelPrecisaExistirNoSistema(repositorio));
		adicionarRegra(new AluguelSituacaoDeCancelamentoValida(repositorio));
	}
}
