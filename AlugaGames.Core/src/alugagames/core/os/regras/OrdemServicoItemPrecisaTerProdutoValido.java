package alugagames.core.os.regras;

import alugagames.core.consoles.Console;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.TipoEquipamento;
import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.shared.Produto;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoItemPrecisaTerProdutoValido implements IRegra<OrdemServicoItem> {

	private IOrdemServicoRepositorio _repositorio;
	
	public OrdemServicoItemPrecisaTerProdutoValido(IOrdemServicoRepositorio repositorio) {
		_repositorio = repositorio;
	}

	@Override
	public String validar(OrdemServicoItem obj) {
		boolean equipamento = false;
		
		for (TipoEquipamento tipo : TipoEquipamento.values()) {
			if(tipo.toString() == obj.getDescricao()){
				equipamento = true;
				break;
			}
		}
		
		Produto p;
		
		if(equipamento)
			p = _repositorio.buscarProdutoPorNumeroSerie(Equipamento.class, obj.getNumeroSerie());
		else
			p = _repositorio.buscarProdutoPorNumeroSerie(Console.class, obj.getNumeroSerie());
		
		if(p == null)
			return "Item "+ obj.getDescricao() +" série "+ obj.getNumeroSerie() +" não existe no sistema.";
		
		if(!p.isAtivo())
			return "Produto " + obj.getDescricao() + " série " + obj.getNumeroSerie() + " está inativo.";
		else if(p.getStatus() != StatusProduto.Avariado)
			return "Produto " + obj.getDescricao() + " série " + obj.getNumeroSerie() + " não está avariado.";
		
		return null;
	}

}
