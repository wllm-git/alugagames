package alugagames.core.orcamentos.regras;

import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.orcamentos.Orcamento;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrcamentoPrecisarTerAtendenteValido implements IRegra<Orcamento> {

	private FuncionarioServico _funcionarioServico;
	
	public OrcamentoPrecisarTerAtendenteValido(FuncionarioServico funcionarioServico) {
		_funcionarioServico = funcionarioServico;
	}

	@Override
	public String validar(Orcamento obj) {
		if(obj.getAtendente() == null)
			return "Atendente não informado.";
		
		Funcionario f = _funcionarioServico.buscarPorId(obj.getAtendente().getId());
		if(f == null)
			return "Atendente informado não cadastrado no sistema.";
		else if(f.getFuncao() != Funcao.Atendente || !f.isAtivo())
			return "Atendente inválido.";
		
		return null;
	}

}
