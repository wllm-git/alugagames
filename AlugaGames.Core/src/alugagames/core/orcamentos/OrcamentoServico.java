package alugagames.core.orcamentos;

import java.util.Date;
import java.util.List;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaAdicionarItens;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaIniciar;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaRemoverItens;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaSerAberto;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaSerAceito;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaSerAvaliado;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaSerCancelado;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaSerConfirmado;
import alugagames.core.orcamentos.validacoes.OrcamentoAptoParaSerRecebido;
import alugagames.core.orcamentos.validacoes.OrcamentoItemAptoParaOrcamento;
import alugagames.core.orcamentos.validacoes.OrcamentoItemAptoParaSerConfirmado;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class OrcamentoServico {
	private IOrcamentoRepositorio _repositorio;
	private ClienteServico _clienteServico;
	private TipoConsoleServico _tipoConsoleServico;
	private FuncionarioServico _funcionarioServico;
	
	public OrcamentoServico(IOrcamentoRepositorio repositorio, ClienteServico clienteServico, TipoConsoleServico tipoConsoleServico,
						FuncionarioServico funcionarioServico){
		_repositorio = repositorio;
		_clienteServico = clienteServico;
		_tipoConsoleServico = tipoConsoleServico;
		_funcionarioServico = funcionarioServico;
	}
	
	public Orcamento iniciarOrcamento(Cliente cliente){
		Orcamento orcamento = new Orcamento();
		orcamento.setCliente(cliente);
		orcamento.setCodigo(_repositorio.getNextCodigo());
		orcamento.setStatus(StatusOrcamento.Iniciado);
		
		List<String> erros = new OrcamentoAptoParaIniciar(_clienteServico).validar(orcamento);
		if(!erros.isEmpty()){
			StringBuilder msg = new StringBuilder();
			for(String err : erros){
				msg.append(err);
				msg.append("\n");
			}
			throw new RuntimeException(msg.toString());
		}else
			_repositorio.adicionar(orcamento);
				
		return orcamento;
	}
	
	public List<String> abrirOrcamento(Orcamento orcamento){
		List<String> erros = new OrcamentoAptoParaSerAberto().validar(orcamento);
		
		for (OrcamentoItem item : orcamento.getOrcamentoItens()) {
			erros.addAll(new OrcamentoItemAptoParaOrcamento(_tipoConsoleServico).validar(item));
			item.setOrcamento(orcamento);
		}
		
		if(!erros.isEmpty())
			return erros;
		
		orcamento.setStatus(StatusOrcamento.Aberto);
		orcamento.setDataAbertura(new Date());
		_repositorio.adicionar(orcamento);
		
		return erros;
	}
	
	public List<String> receberOrcamento(Orcamento orcamento){
		
		List<String> erros = new OrcamentoAptoParaSerRecebido(_funcionarioServico).validar(orcamento);
		if(!erros.isEmpty())
			return erros;
		
		orcamento.setStatus(StatusOrcamento.Recebido);
		for (OrcamentoItem item : orcamento.getOrcamentoItens()) {
			item.setOrcamento(orcamento);
		}
		
		_repositorio.alterar(orcamento);
		
		return erros;
	}
	
	public List<String> avaliarOrcamento(Orcamento orcamento){
		List<String> erros = new OrcamentoAptoParaSerAvaliado(_funcionarioServico).validar(orcamento);
		if(!erros.isEmpty())
			return erros;
		
		orcamento.setStatus(StatusOrcamento.Avaliando);
		
		_repositorio.alterar(orcamento);
		
		return erros;
	}
	
	public List<String> confirmarOrcamento(Orcamento orcamento){
		List<String> erros = new OrcamentoAptoParaSerConfirmado().validar(orcamento);
		
		for (OrcamentoItem item : orcamento.getOrcamentoItens()) {
			erros.addAll(new OrcamentoItemAptoParaSerConfirmado().validar(item));
		}
		
		if(!erros.isEmpty())
			return erros;
		
		orcamento.setStatus(StatusOrcamento.Confirmado);
		orcamento.setValor(0);
		for (OrcamentoItem item : orcamento.getOrcamentoItens()) {
			orcamento.setValor(orcamento.getValor() + item.getValor());
		}
		
		_repositorio.alterar(orcamento);
		
		return erros;
	}
	
	public List<String> aceitarOrcamento(Orcamento orcamento){
		List<String> erros = new OrcamentoAptoParaSerAceito().validar(orcamento);
		if(!erros.isEmpty())
			return erros;
		
		orcamento.setStatus(StatusOrcamento.Aceito);
		
		_repositorio.alterar(orcamento);
		
		return erros;
	}
	
	public List<String> cancelar(Orcamento orcamento){
		List<String> erros = new OrcamentoAptoParaSerCancelado().validar(orcamento);
		if(!erros.isEmpty())
			return erros;
		
		orcamento.setStatus(StatusOrcamento.Cancelado);
		
		_repositorio.alterar(orcamento);
		
		return erros;
	}
	
	public Orcamento buscarOrcamentoPorCodigo(int codigo){
		return _repositorio.buscarPorCodigo(codigo);
	}
	
	public List<String> adicionarItens(Orcamento orcamento, OrcamentoItem item){
		List<String> erros = new OrcamentoAptoParaAdicionarItens().validar(orcamento);
		if(!erros.isEmpty())
			return erros;
		
		erros = new OrcamentoItemAptoParaOrcamento(_tipoConsoleServico).validar(item);
		if(!erros.isEmpty())
			return erros;
		
		orcamento.getOrcamentoItens().add(item);
		item.setOrcamento(orcamento);
		
		_repositorio.alterar(orcamento);
		
		return erros;
	}
	
	public List<String> removerItens(Orcamento orcamento, OrcamentoItem item){
		List<String> erros = new OrcamentoAptoParaRemoverItens().validar(orcamento);
		if(!erros.isEmpty())
			return erros;
		
		boolean removido = false;
		for(OrcamentoItem it : orcamento.getOrcamentoItens()){
			if(it.getId().equals(item.getId())){
				orcamento.getOrcamentoItens().remove(it);
				removido = true;
				break;
			}
		}
		
		if(removido)
			_repositorio.alterar(orcamento);
		
		return erros;
	}
	
}
