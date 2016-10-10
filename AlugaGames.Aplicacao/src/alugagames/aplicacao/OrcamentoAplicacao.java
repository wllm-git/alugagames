package alugagames.aplicacao;

import java.util.List;

import alugagames.core.clientes.Cliente;
import alugagames.core.clientes.ClienteServico;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.orcamentos.OrcamentoItem;
import alugagames.core.orcamentos.OrcamentoServico;
import alugagames.core.os.OrdemServicoServico;
import alugagames.core.tiposconsole.TipoConsoleServico;
import alugagames.repositorio.ClienteRepositorio;
import alugagames.repositorio.FuncionarioRepositorio;
import alugagames.repositorio.OrcamentoRepositorio;
import alugagames.repositorio.OrdemServicoRepositorio;
import alugagames.repositorio.TipoConsoleRepositorio;

public class OrcamentoAplicacao extends AplicacaoBase{
	private OrcamentoServico _orcamentoServico;
	
	public OrcamentoAplicacao(){
		ClienteServico clienteServico = new ClienteServico(new ClienteRepositorio());
		TipoConsoleServico tipoConsoleServico = new TipoConsoleServico(new TipoConsoleRepositorio());
		FuncionarioServico funcionarioServico = new FuncionarioServico(new FuncionarioRepositorio()); 
		
		_orcamentoServico = new OrcamentoServico(new OrcamentoRepositorio(), clienteServico, 
													tipoConsoleServico, funcionarioServico);
	}
	
	public Orcamento iniciarOrcamento(Cliente cliente){
		beginTransaction();
		try{
			Orcamento orcamento = _orcamentoServico.iniciarOrcamento(cliente);
			commit();
			return orcamento;
		}
		catch(RuntimeException ex ){
			rollback();
			throw ex;
		}
	}
	
	public List<String> abrirOrcamento(Orcamento orcamento){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.abrirOrcamento(orcamento);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
	
	public List<String> receberOrcamento(Orcamento orcamento){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.receberOrcamento(orcamento);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
	
	public List<String> avaliarOrcamento(Orcamento orcamento){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.avaliarOrcamento(orcamento);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
	
	public List<String> confirmarOrcamento(Orcamento orcamento){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.confirmarOrcamento(orcamento);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
	
	public List<String> aceitarOrcamento(Orcamento orcamento){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.aceitarOrcamento(orcamento);
		
		if(erros.isEmpty()){
			OrdemServicoServico _osServico = new OrdemServicoServico(new OrdemServicoRepositorio());
			erros = _osServico.abrirOSAutomatica(orcamento);
		}
		
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
	
	public List<String> cancelar(Orcamento orcamento){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.cancelar(orcamento);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
	
	public Orcamento buscarOrcamentoPorCodigo(int codigo){
		return _orcamentoServico.buscarOrcamentoPorCodigo(codigo);
	}
	
	public List<String> adicionarItens(Orcamento orcamento, OrcamentoItem item){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.adicionarItens(orcamento, item);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
	
	public List<String> removerItens(Orcamento orcamento, OrcamentoItem item){
		beginTransaction();
		
		List<String> erros = _orcamentoServico.removerItens(orcamento, item);
		if(!erros.isEmpty())
			rollback();
		else
			commit();
			
		return erros;
	}
}
