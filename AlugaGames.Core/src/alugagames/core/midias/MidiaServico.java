package alugagames.core.midias;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import alugagames.core.equipamentos.Equipamento;
import alugagames.core.jogos.JogoServico;
import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.midias.validacoes.MidiaAptaParaAlteracao;
import alugagames.core.midias.validacoes.MidiaAptaParaAlugar;
import alugagames.core.midias.validacoes.MidiaAptaParaCadastro;
import alugagames.core.midias.validacoes.MidiaAptaParaReserva;
import alugagames.core.midias.validacoes.MidiaAptaParaSerAtivada;
import alugagames.core.midias.validacoes.MidiaAptaParaSerInativada;
import alugagames.core.shared.ServicoBase;
import alugagames.core.shared.StatusProduto;
import alugagames.core.tiposconsole.TipoConsole;
import alugagames.core.tiposconsole.TipoConsoleServico;

public class MidiaServico extends ServicoBase<Midia> {

	private IMidiaRepositorio _repositorio;
	private JogoServico _jogoServico;
	private TipoConsoleServico _tipoConsoleServico;
	
	public MidiaServico(IMidiaRepositorio repositorio) {
		super(repositorio);
		
		_repositorio = repositorio;
	}

	public MidiaServico(IMidiaRepositorio repositorio, JogoServico jogoServico,
				TipoConsoleServico tipoConsoleServico) {
		super(repositorio);
		
		_repositorio = repositorio;
		_jogoServico = jogoServico;
		_tipoConsoleServico = tipoConsoleServico;
	}
	
	public List<String> adicionarMidia(Midia midia) {
		List<String> erros = new MidiaAptaParaCadastro(_repositorio, _jogoServico, _tipoConsoleServico).validar(midia);
		if(erros.isEmpty()){
			midia.setStatus(StatusProduto.Disponivel);
			midia.setAtivo(true);
			
			_repositorio.adicionar(midia);
		}
		return erros;
	}

	public List<String> atualizarMidia(Midia midia) {
		List<String> erros = new MidiaAptaParaAlteracao(_repositorio, _jogoServico, _tipoConsoleServico).validar(midia);
		if(erros.isEmpty())
			_repositorio.alterar(midia);
		
		return erros;
	}
	
	public List<String> inativarMidia(Midia midia){
		
		List<String> erros = new MidiaAptaParaSerInativada(_repositorio).validar(midia);
		if(!erros.isEmpty())
			return erros;
		
		midia.setAtivo(false);
		_repositorio.alterar(midia);
		
		return erros;
	}
	
	public List<String> ativarMidia(Midia midia){
		
		List<String> erros = new MidiaAptaParaSerAtivada(_repositorio).validar(midia);
		if(!erros.isEmpty())
			return erros;
		
		midia.setAtivo(true);
		_repositorio.alterar(midia);
		
		return erros;
	}

	public List<String> reservar(Midia midia) {
		List<String> erros = new MidiaAptaParaReserva(_repositorio).validar(midia);
		if(erros.isEmpty()){
			midia.setStatus(StatusProduto.Reservado);
			_repositorio.atualizarStatusMidia(midia);
		}
		
		return erros;
	}

	public void liberar(Midia midia) {
		midia.setStatus(StatusProduto.Disponivel);
		_repositorio.atualizarStatusMidia(midia);
	}

	public Collection<String> alugar(Midia midia) {
		List<String> erros = new MidiaAptaParaAlugar(_repositorio).validar(midia);
		if(erros.isEmpty()){
			midia.setStatus(StatusProduto.Reservado);
			_repositorio.atualizarStatusMidia(midia);
		}
		
		return erros;
	}

	public List<String> midiaAptaParaReserva(Midia midia) {
		return new MidiaAptaParaReserva(_repositorio).validar(midia);
	}

	public void atualizarStatus(Midia midia) {
		_repositorio.atualizarStatusMidia(midia);
	}
	
	public void excluir(Midia midia){
		_repositorio.excluir(midia);
	}
	
	public List<Midia> buscarPorTipoConsole(TipoConsole tipoConsole){
		List<Midia> midiasDisponiveis = new ArrayList<Midia>();
		
		UUID id = null;
		if(tipoConsole != null)
			id = tipoConsole.getId();
		
		List<Midia> midias = this.buscarTodos();
		for(Midia midia : midias){
			if(midia.isAtivo() && 
					midia.getStatus().equals(StatusProduto.Disponivel) &&
					(id == null || midia.getTipoConsole().getId().equals(id))
					){
				midiasDisponiveis.add(midia);
			}
		}
		
		return midiasDisponiveis;
	}
}
