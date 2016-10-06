package alugagames.core.alugueis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerCancelado;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerConfirmado;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerFinalizado;
import alugagames.core.alugueis.validacoes.ReservaAptaParaSerConfirmada;
import alugagames.core.alugueis.validacoes.ReservaAptaParaSerIniciada;
import alugagames.core.atendentes.AtendenteServico;
import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.consoles.Console;
import alugagames.core.consoles.ConsoleServico;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.EquipamentoServico;
import alugagames.core.midias.Midia;
import alugagames.core.midias.MidiaServico;
import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.OrdemServicoServico;
import alugagames.core.shared.StatusProduto;

public class AluguelServico {
	private IAluguelRepositorio _repositorio;
	private ClienteServico _clienteServico;
	private ConsoleServico _consoleServico;
	private MidiaServico _midiaServico;
	private EquipamentoServico _equipamentoServico;
	private AtendenteServico _atendenteServico;
	private OrdemServicoServico _ordemServicoServico;
	
	public AluguelServico(IAluguelRepositorio repositorio, ClienteServico clienteServico, 
							AtendenteServico atendenteServico, ConsoleServico consoleServico, 
							MidiaServico midiaServico, EquipamentoServico acessorioServico,
							OrdemServicoServico ordemServicoServico){
		_repositorio = repositorio;
		_clienteServico = clienteServico;
		_consoleServico = consoleServico;
		_midiaServico = midiaServico;
		_equipamentoServico = acessorioServico;
		_atendenteServico = atendenteServico;
		_ordemServicoServico = ordemServicoServico;
	}
	
	public Aluguel abrirReserva(Cliente cliente){
		
		Aluguel aluguel = new Aluguel();
		aluguel.setCodigo(_repositorio.getNextCodigo());
		aluguel.setCliente(cliente);
		
		
		List<String> erros = new ReservaAptaParaSerIniciada(_clienteServico).validar(aluguel); 
		
		if(!erros.isEmpty()){
			StringBuilder msg = new StringBuilder();
			for(String err : erros){
				msg.append(err);
				msg.append("\n");
			}
			throw new RuntimeException(msg.toString());
		}else
			_repositorio.adicionar(aluguel);
		
		return aluguel;
	}
	
	public List<String> confirmarReserva(Aluguel aluguel){
		
		List<String> erros = new ReservaAptaParaSerConfirmada().validar(aluguel);
		if(!erros.isEmpty())
			return erros;
				
		for(Console c : aluguel.getConsoles()){
			erros.addAll(_consoleServico.reservar(c));
		}
		
		for(Midia m : aluguel.getMidias()){
			erros.addAll(_midiaServico.reservar(m));
		}
				
		for(Equipamento e : aluguel.getEquipamentos()){
			erros.addAll(_equipamentoServico.reservar(e));
		}
		
		
		if(erros.isEmpty()){
			aluguel.setStatus(StatusAluguel.Reservado);
			aluguel.setDataReserva(new Date());
			
			_repositorio.alterar(aluguel);
		}
		
		return erros;
	}
	
	public List<String> confirmarAluguel(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerConfirmado(_repositorio, _atendenteServico).validar(aluguel);
		
		if(!erros.isEmpty())
			return erros;
		
		for(Console c : aluguel.getConsoles()){
			erros.addAll(_consoleServico.alugar(c));
		}
		
		for(Midia m : aluguel.getMidias()){
			erros.addAll(_midiaServico.alugar(m));
		}
				
		for(Equipamento e : aluguel.getEquipamentos()){
			erros.addAll(_equipamentoServico.alugar(e));
		}
		
		aluguel.setStatus(StatusAluguel.Confirmado);
		aluguel.setDataConfirmacao(new Date());
		
		if(erros.isEmpty())
			_repositorio.alterar(aluguel);
		
		return erros;
	}
	
	public List<String> finalizarAluguel(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerFinalizado(_repositorio).validar(aluguel);
		
		if(!erros.isEmpty())
			return erros;
		
		List<OrdemServicoItem> osItens = new ArrayList<OrdemServicoItem>();
		OrdemServicoItem item;
		
		for(Console c : aluguel.getConsoles()){
			if(!c.getStatus().equals(StatusProduto.Avariado))
				_consoleServico.liberar(c);
			else{
				item = new OrdemServicoItem();
				item.setDescricao(c.getTipoConsole().getNome());
				item.setNumeroSerie(c.getNumeroSerie());
				osItens.add(item);
			}
		}
		
		for(Midia m : aluguel.getMidias()){
			if(!m.getStatus().equals(StatusProduto.Avariado))
				_midiaServico.liberar(m);
			else{
				item = new OrdemServicoItem();
				item.setDescricao(m.getTipoConsole().getNome());
				item.setNumeroSerie(m.getNumeroSerie());
				osItens.add(item);
			}
		}
				
		for(Equipamento e : aluguel.getEquipamentos()){
			if(!e.getStatus().equals(StatusProduto.Avariado))
				_equipamentoServico.liberar(e);
			else{
				item = new OrdemServicoItem();
				item.setDescricao(e.getTipoEquipamento().toString());
				item.setNumeroSerie(e.getNumeroSerie());
				osItens.add(item);
			}
		}
		
		if(!osItens.isEmpty()){
			erros = _ordemServicoServico.abrirOS(aluguel, osItens);
			
			if(!erros.isEmpty())
				return erros;
		}
		
		
		aluguel.setStatus(StatusAluguel.Fechado);
		aluguel.setDataFechamento(new Date());
		
		_repositorio.alterar(aluguel);
		
		return erros;
	}
	
	public List<String> cancelar(Aluguel aluguel){
		List<String> erros = new AluguelAptoParaSerCancelado(_repositorio).validar(aluguel);
		
		if(!erros.isEmpty())
			return erros;
		
		for(Console c : aluguel.getConsoles()){
			_consoleServico.liberar(c);
		}
		
		for(Midia m : aluguel.getMidias()){
			_midiaServico.liberar(m);
		}
				
		for(Equipamento e : aluguel.getEquipamentos()){
			_equipamentoServico.liberar(e);
		}
		
		aluguel.setStatus(StatusAluguel.Cancelado);
		aluguel.setDataFechamento(new Date());
		
		_repositorio.alterar(aluguel);
		
		return erros;
	}
	
	public Aluguel buscarReservaPorCodigo(int codigo){
		Aluguel aluguel = _repositorio.buscarPorCodigo(codigo); 
		
		if(aluguel != null){
			if(!aluguel.isAluguel())
				return aluguel;
			
			aluguel = null;
		}
		
		return aluguel;
	}
	
	public Aluguel buscarAluguelPorCodigo(int codigo){
		Aluguel aluguel = _repositorio.buscarPorCodigo(codigo); 
		
		if(aluguel != null){
			if(aluguel.isAluguel())
				return aluguel;
			
			aluguel = null;
		}
		
		return aluguel;
	}
	
	public List<String> adicionarConsoles(Aluguel aluguel, List<Console> consoles){
		return null;
	}
	
	public List<String> adicionarMidias(Aluguel aluguel, List<Midia> midias){
		return null;
	}
	
	public List<String> adicionarAcessorios(Aluguel aluguel, List<Equipamento> acessorios){
		return null;
	}
	
	public List<String> removerConsoles(Aluguel aluguel, List<Console> consoles){
		return null;
	}
	
	public List<String> removerMidias(Aluguel aluguel, List<Midia> midias){
		return null;
	}
	
	public List<String> removerAcessorios(Aluguel aluguel, List<Equipamento> acessorios){
		return null;
	}
}
