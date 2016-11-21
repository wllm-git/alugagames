package alugagames.core.os.regras;

import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.os.OrdemServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaTerTecnicoValido implements IRegra<OrdemServico> {

	private FuncionarioServico _funcionarioServico;
	
	public OrdemServicoPrecisaTerTecnicoValido(FuncionarioServico funcionarioServico) {
		_funcionarioServico = funcionarioServico;
	}
	
	@Override
	public String validar(OrdemServico obj) {
		if(obj.getTecnico() == null)
			return "Técnico não informado.";
		
		Funcionario f = _funcionarioServico.buscarPorID(obj.getTecnico().getId());
		if(f == null)
			return "Técnico informado não cadastrado no sistema.";
		else if(f.getFuncao() != Funcao.Tecnico || !f.isAtivo())
			return "Técnico inválido.";
		
		return null;
	}
}
