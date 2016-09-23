package alugagames.core.os;

import java.util.List;

import alugagames.core.clientes.Cliente;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;

public class OrdemServicoServico {
	private IOrdemServicoRepositorio _repositorio;
	
	public OrdemServicoServico(IOrdemServicoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public List<String> abrirOSInterna(List<OrdemServicoItem> itens){
		return null;
	}
	
	public List<String> abrirOS(Cliente cliente, List<OrdemServicoItem> itens){
		return null;
	}
	
	public List<String> abrirOS(Orcamento orcamento){
		return null;
	}
	
	public List<String> processarOS(OrdemServico ordemServico){
		return null;
	}
	
	public List<String> fecharOS(OrdemServico ordemServico){
		return null;
	}
	
	public OrdemServico buscarPorCodigo(int codigo){
		return null;
	}
}
