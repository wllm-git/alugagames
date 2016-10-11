package alugagames.core.os.validacoes;

import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.regras.OrdemServicoItemPrecisaTerDescricaoValdia;
import alugagames.core.os.regras.OrdemServicoItemPrecisaTerNumeroDeSerieValido;
import alugagames.core.os.regras.OrdemServicoItemPrecisaTerProdutoValido;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.shared.validacoesregras.Validacao;

public class OrdemServicoItemAptoParaOSInterna extends Validacao<OrdemServicoItem>{
	public OrdemServicoItemAptoParaOSInterna(IOrdemServicoRepositorio repositorio){
		adicionarRegra(new OrdemServicoItemPrecisaTerDescricaoValdia());
		adicionarRegra(new OrdemServicoItemPrecisaTerNumeroDeSerieValido());
		adicionarRegra(new OrdemServicoItemPrecisaTerProdutoValido(repositorio));
	}
}
