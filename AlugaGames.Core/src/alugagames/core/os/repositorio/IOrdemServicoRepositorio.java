package alugagames.core.os.repositorio;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.os.OrdemServico;
import alugagames.core.shared.Produto;
import alugagames.core.shared.StatusProduto;
import alugagames.core.shared.repositorio.IRepositorioBase;

public interface IOrdemServicoRepositorio extends IRepositorioBase<OrdemServico> {
	public int getNextCodigo();
	
	public OrdemServico buscarPorAluguel(Aluguel aluguel);
	
	public OrdemServico buscarPorOrcamento(Orcamento orcamento);
	
	public OrdemServico buscarPorCodigo(int codigo);

	public OrdemServico buscarPorCPFCliente(String cpf);

	public void atualizarStatusEquipamento(String numeroSerie, StatusProduto status);

	public void atualizarStatusConsole(String numeroSerie, StatusProduto status);

	public Produto buscarProdutoPorNumeroSerie(Class classe, String numeroSerie);
}
