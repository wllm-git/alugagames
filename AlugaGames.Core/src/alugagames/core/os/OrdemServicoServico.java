package alugagames.core.os;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.os.repositorio.IOrdemServicoRepositorio;
import alugagames.core.os.validacoes.OrdemServicoAptaParaFinalizarServico;
import alugagames.core.os.validacoes.OrdemServicoAptaParaProcessamento;
import alugagames.core.os.validacoes.OrdemServicoAptaParaSerFechada;
import alugagames.core.os.validacoes.OrdemServicoItemAptoParaOSInterna;
import alugagames.core.os.validacoes.OrdemServicoItemAptoParafinalizarServico;
import alugagames.core.shared.ServicoBase;
import alugagames.core.shared.StatusProduto;

public class OrdemServicoServico extends ServicoBase<OrdemServico>{
	private IOrdemServicoRepositorio _repositorio;
	
	public OrdemServicoServico(IOrdemServicoRepositorio repositorio){
		super(repositorio);
		_repositorio = repositorio;
	}
	
	public List<String> abrirOSInterna(Funcionario atendente, List<OrdemServicoItem> itens){
		List<String> erros = new ArrayList<>();
		
		OrdemServico os = new OrdemServico();
		os.setAtendente(atendente);
		os.setDataAbertura(new Date());
		os.setInterna(true);
		os.setStatus(StatusOS.Aberta);
		os.setDescricao("OS interna");
		os.setValor(0);
		os.setCodigo(_repositorio.getNextCodigo());
		
		for (OrdemServicoItem item : itens) {
			erros.addAll(new OrdemServicoItemAptoParaOSInterna(_repositorio).validar(item));
			
			item.setStatusOSItem(StatusOSItem.Recebido);
			item.setOrdemServico(os);
			item.setValor(0);
		}
		
		if(!erros.isEmpty())
			return erros;
		
		os.setOrdemServicoItens(itens);
		_repositorio.adicionar(os);
		
		return erros;
	}
	
	public List<String> abrirOSAutomatica(Aluguel aluguel, List<OrdemServicoItem> itens){
		List<String> erros = new ArrayList<>();
		
		OrdemServico os = new OrdemServico();
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
	
	public List<String> abrirOSAutomatica(Orcamento orcamento){
		List<String> erros = new ArrayList<>();
		
		OrdemServico os = new OrdemServico();
		os.setCliente(orcamento.getCliente());
		os.setDataAbertura(new Date());
		os.setInterna(false);
		os.setStatus(StatusOS.Aberta);
		os.setDescricao(orcamento.getDescricao());
		os.setValor(orcamento.getValor());
		os.setCodigo(_repositorio.getNextCodigo());
		
		List<OrdemServicoItem> itens = new ArrayList<>();
		
		for (OrcamentoItem itemOrcamento : orcamento.getOrcamentoItens()) {
			
			OrdemServicoItem itemOS = new OrdemServicoItem();
			
			itemOS.setNumeroSerie(itemOrcamento.getNumeroSerie());
			itemOS.setDescricao(itemOrcamento.getDescricao());
			itemOS.setStatusOSItem(StatusOSItem.Recebido);
			itemOS.setOrdemServico(os);
			itemOS.setValor(itemOrcamento.getValor());
			
			itens.add(itemOS);
		}
		
		os.setOrdemServicoItens(itens);
		try {
			_repositorio.adicionar(os);
		} catch (Exception e) {
			erros.add("Erro ao gerar OS: " + e.getMessage());
		}
		
		return erros;
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
		List<String> erros = new OrdemServicoAptaParaSerFechada().validar(ordemServico);
		
		if(!erros.isEmpty())
			return erros;
		
		if(ordemServico.isInterna())
			fecharOSInterna(ordemServico);
				
		for (OrdemServicoItem item : ordemServico.getOrdemServicoItens()) {
			item.setStatusOSItem(StatusOSItem.Entregue);
		}
		
		ordemServico.setStatus(StatusOS.Fechada);
		ordemServico.setDataFechamento(new Date());
		
		_repositorio.alterar(ordemServico);
		
		return erros;
	}
	
	private void fecharOSInterna(OrdemServico ordemServico){
		
		for (OrdemServicoItem item : ordemServico.getOrdemServicoItens()) {
			
			if(item.getStatusOSItem() == StatusOSItem.SemConserto)
				continue;
			
			boolean equipamento = false;
			for (StatusOSItem status : StatusOSItem.values()) {
				if(status.toString().equals(item.getDescricao())){
					equipamento = true;
					break;
				}
			}
			
			if(equipamento){
				_repositorio.atualizarStatusEquipamento(item.getNumeroSerie(), StatusProduto.Disponivel);
			}else{
				_repositorio.atualizarStatusConsole(item.getNumeroSerie(), StatusProduto.Disponivel);
			}
		}
	}
	
	public OrdemServico buscarPorCodigo(int codigo){
		return _repositorio.buscarPorCodigo(codigo);
	}
	
	public OrdemServico buscarPorCPFCliente(String cpf){
		return _repositorio.buscarPorCPFCliente(cpf);
	}
}
