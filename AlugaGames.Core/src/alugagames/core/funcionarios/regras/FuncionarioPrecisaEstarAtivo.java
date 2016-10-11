package alugagames.core.funcionarios.regras;

import alugagames.core.funcionarios.Funcionario;
import alugagames.core.shared.validacoesregras.IRegra;

public class FuncionarioPrecisaEstarAtivo implements IRegra<Funcionario> {

	@Override
	public String validar(Funcionario obj) {
		if(!obj.isAtivo())
			return "Funcionário "+ obj.getNome() + " precisa está ativo para ser atualizado.";
		return null;
	}

}
