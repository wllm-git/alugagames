package alugagames.core.alugueis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import alugagames.core.alugueis.repositorio.IAluguelRepositorio;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerCancelado;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerConfirmado;
import alugagames.core.alugueis.validacoes.AluguelAptoParaSerFinalizado;
import alugagames.core.alugueis.validacoes.ReservaAptaParaAdicionarProdutos;
import alugagames.core.alugueis.validacoes.ReservaAptaParaRemoverProdutos;
import alugagames.core.alugueis.validacoes.ReservaAptaParaSerConfirmada;
import alugagames.core.alugueis.validacoes.ReservaAptaParaSerIniciada;
import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.consoles.Console;
import alugagames.core.consoles.ConsoleServico;
import alugagames.core.equipamentos.Equipamento;
import alugagames.core.equipamentos.EquipamentoServico;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.midias.Midia;
import alugagames.core.midias.MidiaServico;
import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.OrdemServicoServico;
import alugagames.core.shared.ServicoBase;
import alugagames.core.shared.StatusProduto;

public class AluguelServico extends ServicoBase<Aluguel>{
	private IAluguelRepositorio _repositorio;
	private ClienteServico _clienteServico;
	private ConsoleServico _consoleServico;
	private MidiaServico _midiaServico;
	private EquipamentoServico _equipamentoServico;
	private FuncionarioServico _atendenteServico;
	private OrdemServicoServico _ordemServicoServico;
	
	public AluguelServico(IAluguelRepositorio repositorio, ClienteServico clienteServico, 
							FuncionarioServico atendenteServico, ConsoleServico consoleServico, 
							MidiaServico midiaServico, EquipamentoServico acessorioServico,
							OrdemServicoServico ordemServicoServico){
		super(repositorio);
		
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
		
		List<String> erros = new ReservaAptaParaSerConfirmada(_clienteServico).validar(aluguel);
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
		List<String> erros = new AluguelAptoParaSerConfirmado(_repositorio, _clienteServico, _atendenteServico).validar(aluguel);
		
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
		List<String> erros = new AluguelAptoParaSerFinalizado(_repositorio, _atendenteServico).validar(aluguel);
		
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
			erros = _ordemServicoServico.abrirOSAutomatica(aluguel, osItens);
			
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
	
	public List<String> adicionarConsoles(Aluguel reserva, List<Console> consoles){
		List<String> erros = new ReservaAptaParaAdicionarProdutos().validar(reserva);
		
		if(!erros.isEmpty())
			return erros;
		
		boolean reservado = reserva.getStatus() == StatusAluguel.Reservado;
		
		for (Console console : consoles) {
			if(reservado)
				erros.addAll(_consoleServico.reservar(console));
			else
				erros.addAll(_consoleServico.consoleAptoParaReserva(console));
		}

		if(!erros.isEmpty())
			return erros;
		
		reserva.getConsoles().addAll(consoles);
		_repositorio.alterar(reserva);
		
		return erros;
	}
	
	public List<String> adicionarMidias(Aluguel reserva, List<Midia> midias){
		List<String> erros = new ReservaAptaParaAdicionarProdutos().validar(reserva);
		
		if(!erros.isEmpty())
			return erros;
		
		boolean reservado = reserva.getStatus() == StatusAluguel.Reservado;
		
		for (Midia midia : midias) {
			if(reservado)
				erros.addAll(_midiaServico.reservar(midia));
			else
				erros.addAll(_midiaServico.midiaAptaParaReserva(midia));
		}

		if(!erros.isEmpty())
			return erros;
		
		reserva.getMidias().addAll(midias);
		_repositorio.alterar(reserva);
		
		return erros;
	}
	
	public List<String> adicionarEquipamentos(Aluguel reserva, List<Equipamento> equipamentos){
		List<String> erros = new ReservaAptaParaAdicionarProdutos().validar(reserva);
		
		if(!erros.isEmpty())
			return erros;
		
		boolean reservado = reserva.getStatus() == StatusAluguel.Reservado;
		
		for (Equipamento equipamento : equipamentos) {
			if(reservado)
				erros.addAll(_equipamentoServico.reservar(equipamento));
			else
				erros.addAll(_equipamentoServico.equipamentoAptoParaReserva(equipamento));
		}

		if(!erros.isEmpty())
			return erros;
		
		reserva.getEquipamentos().addAll(equipamentos);
		_repositorio.alterar(reserva);
		
		return erros;
	}
	
	public List<String> removerConsoles(Aluguel reserva, List<Console> consoles){
		List<String> erros = new ReservaAptaParaRemoverProdutos().validar(reserva);
		
		if(!erros.isEmpty())
			return erros;
		
		boolean reservado = reserva.getStatus() == StatusAluguel.Reservado;
		
		for (Console console : consoles) {
			
			for (Console c : reserva.getConsoles()) {
				if(c.getId().equals(console.getId())){
					reserva.getConsoles().remove(c);
					
					if(reservado){
						if(console.getStatus() == StatusProduto.Reservado)
							_consoleServico.liberar(console);
						else if(console.getStatus() == StatusProduto.Avariado)
							_consoleServico.atualizarStatus(console);
					}
					
					break;
				}
			}
		}
		
		_repositorio.alterar(reserva);
		
		return erros;
	}
	
	public List<String> removerMidias(Aluguel reserva, List<Midia> midias){
		List<String> erros = new ReservaAptaParaRemoverProdutos().validar(reserva);
		
		if(!erros.isEmpty())
			return erros;
		
		boolean reservado = reserva.getStatus() == StatusAluguel.Reservado;
		
		for (Midia midia : midias) {
			
			for (Midia m : reserva.getMidias()) {
				if(m.getId().equals(midia.getId())){
					reserva.getConsoles().remove(m);
					
					if(reservado){
						if(midia.getStatus() == StatusProduto.Reservado)
							_midiaServico.liberar(midia);
						else if(midia.getStatus() == StatusProduto.Avariado)
							_midiaServico.atualizarStatus(midia);
					}
					
					break;
				}
			}
		}
		
		_repositorio.alterar(reserva);
		
		return erros;
	}
	
	public List<String> removerEquipamentos(Aluguel reserva, List<Equipamento> equipamentos){
		List<String> erros = new ReservaAptaParaRemoverProdutos().validar(reserva);
		
		if(!erros.isEmpty())
			return erros;
		
		boolean reservado = reserva.getStatus() == StatusAluguel.Reservado;
		
		for (Equipamento equipamento : equipamentos) {
			
			for (Equipamento e : reserva.getEquipamentos()) {
				if(e.getId().equals(equipamento.getId())){
					reserva.getConsoles().remove(e);
					
					if(reservado){
						if(equipamento.getStatus() == StatusProduto.Reservado)
							_equipamentoServico.liberar(equipamento);
						else if(equipamento.getStatus() == StatusProduto.Avariado)
							_equipamentoServico.atualizarStatus(equipamento);
					}
					
					break;
				}
			}
		}
		
		_repositorio.alterar(reserva);
		
		return erros;
	}

	public Aluguel buscarPorCliente(Cliente cliente) {
		
		return _repositorio.buscarPorCliente(cliente);
	}
}
