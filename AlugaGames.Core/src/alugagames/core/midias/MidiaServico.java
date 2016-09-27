package alugagames.core.midias;

import java.util.List;

import alugagames.core.midias.repositorio.IMidiaRepositorio;
import alugagames.core.midias.validacoes.MidiaAptaParaCadastro;
import alugagames.core.midias.validacoes.MidiaAptaParaReserva;
import alugagames.core.shared.ServicoBase;
import alugagames.core.shared.StatusProduto;

public class MidiaServico extends ServicoBase<Midia> {

	private IMidiaRepositorio _repositorio;
	
	public MidiaServico(IMidiaRepositorio repositorio) {
		super(repositorio);
		
		_repositorio = repositorio;
	}

	public List<String> adicionarMidia(Midia midia) {
		
		List<String> erros = new MidiaAptaParaCadastro().validar(midia);
		if(erros.isEmpty())
			super.adicionar(midia);
		
		return erros;
	}

	public List<String> atualizarMidia(Midia midia) {

		List<String> erros = new MidiaAptaParaCadastro().validar(midia);
		if(erros.isEmpty())
			super.adicionar(midia);
		
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

}
