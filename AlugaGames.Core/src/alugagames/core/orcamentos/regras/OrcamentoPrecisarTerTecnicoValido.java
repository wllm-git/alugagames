package alugagames.core.orcamentos.regras;

import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisarTerTecnicoValido implements IRegra<Orcamento> {

	private FuncionarioServico _funcionarioServico;
	
	public OrcamentoPrecisarTerTecnicoValido(FuncionarioServico funcionarioServico) {
		_funcionarioServico = funcionarioServico;
	}

	@Override
	public String validar(Orcamento obj) {
		if(obj.getTecnico() == null)
			return "Técnico não informado.";
		
		Funcionario f = _funcionarioServico.buscarPorId(obj.getTecnico().getId());
		if(f == null)
			return "Técnico informado não cadastrado no sistema.";
		else if(f.getFuncao() != Funcao.Tecnico || !f.isAtivo())
			return "Técnico inválido.";
		
		return null;
	}

}
