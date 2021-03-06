package alugagames.aplicacao;

import java.util.List;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.os.OrdemServico;
import alugagames.core.os.OrdemServicoItem;
import alugagames.core.os.OrdemServicoServico;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.OrdemServicoRepositorio;

public class OrdemServicoAplicacao extends AplicacaoBase{
	private OrdemServicoServico _ordemServicoServico;
	
	public OrdemServicoAplicacao(){
		FuncionarioServico atendenteServico = new FuncionarioServico(new FuncionarioRepositorio());
		_ordemServicoServico = new OrdemServicoServico(new OrdemServicoRepositorio(), atendenteServico);
	}
	
	public List<String> abrirOSInterna(Funcionario atendente, List<OrdemServicoItem> itens){
		beginTransaction();
		
		List<String> erros = _ordemServicoServico.abrirOSInterna(atendente, itens);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
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
	
	public List<String> finalizarServico(OrdemServico ordemServico){
		beginTransaction();
		
		List<String> erros = _ordemServicoServico.finalizarServico(ordemServico);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public List<String> fecharOS(OrdemServico ordemServico){
		beginTransaction();
		
		List<String> erros = _ordemServicoServico.fecharOS(ordemServico);
		if(!erros.isEmpty()){
			rollback();
			return erros;
		}
		
		commit();
		
		return erros;
	}
	
	public OrdemServico buscarPorCodigo(int codigo){
		return _ordemServicoServico.buscarPorCodigo(codigo);
	}
	
	public OrdemServico buscarPorCPFCliente(String cpf){
		return _ordemServicoServico.buscarPorCPFCliente(cpf);
	}
}
