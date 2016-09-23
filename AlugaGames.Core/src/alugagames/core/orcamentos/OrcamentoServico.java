package alugagames.core.orcamentos;

import java.util.List;

import alugagames.core.orcamentos.repositorio.IOrcamentoRepositorio;

public class OrcamentoServico {
	private IOrcamentoRepositorio _repositorio;
	
	public OrcamentoServico(IOrcamentoRepositorio repositorio){
		_repositorio = repositorio;
	}
	
	public Orcamento iniciarOrcamento(){
		return null;
	}
	
	public List<String> abrirOrcamento(Orcamento orcamento){
		return null;
	}
	
	public List<String> receberOrcamento(Orcamento orcamento){
		return null;
	}
	
	public List<String> avaliarOrcamento(Orcamento orcamento){
		return null;
	}
	
	public List<String> confirmarOrcamento(Orcamento orcamento){
		return null;
	}
	
	public List<String> aceitarOrcamento(Orcamento orcamento){
		return null;
	}
	
	public List<String> cancelar(Orcamento orcamento){
		return null;
	}
	
	public Orcamento buscarOrcamentoPorCodigo(int codigo){
		return null;
	}
	
	public List<String> adicionarItens(Orcamento orcamento, OrcamentoItem item){
		return null;
	}
	
	public List<String> removerItens(Orcamento orcamento, OrcamentoItem item){
		return null;
	}
	
}
