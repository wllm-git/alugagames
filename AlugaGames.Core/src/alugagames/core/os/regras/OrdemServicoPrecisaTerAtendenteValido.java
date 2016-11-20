package alugagames.core.os.regras;

import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.os.OrdemServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaTerAtendenteValido implements IRegra<OrdemServico> {
	private FuncionarioServico _funcionarioServico;
	
	public OrdemServicoPrecisaTerAtendenteValido(FuncionarioServico funcionarioServico){
		_funcionarioServico = funcionarioServico;
	}
	
	@Override
	public String validar(OrdemServico obj) {
		if(obj.getAtendente() == null)
			return "Atendente não informado.";
		
		Funcionario f = _funcionarioServico.buscarPorID(obj.getAtendente().getId());
		 
		if(f == null)
			 return "Atendente informado não cadastrado no sistema.";
		else if(f.getFuncao() != Funcao.Atendente || !f.isAtivo())
			return "Atendente inválido.";
		
		return null;
	}
}
