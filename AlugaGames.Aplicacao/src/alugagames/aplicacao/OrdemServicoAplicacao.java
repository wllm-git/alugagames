package alugagames.aplicacao;

import java.util.List;

import alugagames.core.os.OrdemServico;
import alugagames.core.os.OrdemServicoServico;
import alugagames.repositorio.OrdemServicoRepositorio;

public class OrdemServicoAplicacao extends AplicacaoBase{
	private OrdemServicoServico _ordemServicoServico;
	
	public OrdemServicoAplicacao(){
		_ordemServicoServico = new OrdemServicoServico(new OrdemServicoRepositorio());
	}
	
	public List<String> processarOS(OrdemServico ordemServico){
		beginTransaction();
		
		List<String> erros = _ordemServicoServico.processarOS(ordemServico);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
}
