package alugagames.core.os;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.atendentes.Atendente;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;

public class OrdemServicoServico {
	private IOrdemServicoRepositorio _repositorio;
	
	public OrdemServicoServico(IOrdemServicoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public List<String> abrirOSInterna(Atendente atendente, List<OrdemServicoItem> itens){
		return null;
	}
	
	public List<String> abrirOS(Aluguel aluguel, List<OrdemServicoItem> itens){
		
		OrdemServico os = new OrdemServico();
		os.setAtendente(aluguel.getAtendente());
		os.setCliente(aluguel.getCliente());
		os.setDataAbertura(new Date());
		os.setInterna(true);
		os.setStatus(StatusOS.Aberta);
		os.setDescricao("Aluguel " + aluguel.getCodigo());
		os.setValor(0);
		os.setCodigo(_repositorio.getNextCodigo());
		
		for (OrdemServicoItem item : itens) {
			item.setStatusOSItem(StatusOSItem.Recebido);
			item.setOrdemServico(os);
			item.setValor(0);
		}
		
		os.setOrdemServicoItens(itens);
		try {
			_repositorio.adicionar(os);
		} catch (Exception e) {
			List<String> erro = new ArrayList<>();
			erro.add("Erro ao gerar OS: " + e.getMessage());
			return erro;
		}
		
		
		return null;
	}
	
	public List<String> abrirOS(Orcamento orcamento){
		return null;
	}
	
	public List<String> processarOS(OrdemServico ordemServico){
		return null;
	}
	
	public List<String> finalizarServico(OrdemServico ordemServico){
		return null;
	}
	
	
	public List<String> fecharOS(OrdemServico ordemServico){
		return null;
	}
	
	public OrdemServico buscarPorCodigo(int codigo){
		return null;
	}
	
	public OrdemServico buscarPorCPFCliente(String cpf){
		return null;
	}
}
