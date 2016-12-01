package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaTerAtendenteFechamentoValido implements IRegra<Aluguel> {

	private FuncionarioServico _atendenteServico;
	
	public AluguelPrecisaTerAtendenteFechamentoValido(FuncionarioServico atendenteServico){
		_atendenteServico = atendenteServico;
	}
	
	@Override
	public String validar(Aluguel obj) {
		if(obj.getAtendenteFechamento() == null)
			return "atendente n�o informado.";
		
		Funcionario a = _atendenteServico.buscarPorID(obj.getAtendenteFechamento().getId());
		
		if(a == null)
			return "atendente n�o existe no sistema.";
		else if(a.getFuncao() != Funcao.Atendente && a.getFuncao() != Funcao.Gerente || !a.isAtivo())
			return "Atendente inv�lido.";
		
		return null;
	}

}
