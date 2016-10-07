package alugagames.core.funcionarios.regras;

import java.util.UUID;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioNaoPodeInativarASeMesmo implements IRegra<Funcionario> {

	private UUID _idFuncionarioLogado;
	
	public FuncionarioNaoPodeInativarASeMesmo(UUID idFuncionarioLogado) {
		_idFuncionarioLogado = idFuncionarioLogado;
	}

	@Override
	public String validar(Funcionario obj) {
		
		if(obj.getId().equals(_idFuncionarioLogado))
			return "Funcionário não pode se inativar.";
		
		return null;
	}

}
