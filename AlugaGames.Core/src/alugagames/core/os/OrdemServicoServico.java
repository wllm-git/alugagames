package alugagames.core.os;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.os.validacoes.OrdemServicoAptaParaFinalizarServico;
import alugagames.core.os.validacoes.OrdemServicoAptaParaProcessamento;
import alugagames.core.os.validacoes.OrdemServicoItemAptoParafinalizarServico;
import alugagames.core.shared.ServicoBase;

public class OrdemServicoServico extends ServicoBase<OrdemServico>{
	private IOrdemServicoRepositorio _repositorio;
	
	public OrdemServicoServico(IOrdemServicoRepositorio repositorio){
		super(repositorio);
		_repositorio = repositorio;
	}
	
	public List<String> abrirOSInterna(Funcionario atendente, List<OrdemServicoItem> itens){
		return null;
	}
	
	public List<String> abrirOS(Aluguel aluguel, List<OrdemServicoItem> itens){
		List<String> erros = new ArrayList<>();
		
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
			erros.add("Erro ao gerar OS: " + e.getMessage());
		}
		
		return erros;
	}
	
	public List<String> abrirOS(Orcamento orcamento){
		return null;
	}
	
	public List<String> processarOS(OrdemServico ordemServico){
		List<String> erros = new OrdemServicoAptaParaProcessamento().validar(ordemServico);
		
		if(!erros.isEmpty())
			return erros;
		
		ordemServico.setStatus(StatusOS.Processamento);
		_repositorio.alterar(ordemServico);
		
		return erros;
	}
	
	public List<String> finalizarServico(OrdemServico ordemServico){
		List<String> erros = new OrdemServicoAptaParaFinalizarServico().validar(ordemServico);
		
		if(!erros.isEmpty())
			return erros;
		
		for (OrdemServicoItem item : ordemServico.getOrdemServicoItens()) {
			erros.addAll(new OrdemServicoItemAptoParafinalizarServico().validar(item));
		}
		
		if(!erros.isEmpty())
			return erros;
		
		ordemServico.setStatus(StatusOS.Aguardando);
		_repositorio.alterar(ordemServico);
		
		return erros;
	}
	
	
	public List<String> fecharOS(OrdemServico ordemServico){
		return null;
	}
	
	public OrdemServico buscarPorCodigo(int codigo){
		return _repositorio.buscarPorCodigo(codigo);
	}
	
	public OrdemServico buscarPorCPFCliente(String cpf){
		return _repositorio.buscarPorCPFCliente(cpf);
	}
}
