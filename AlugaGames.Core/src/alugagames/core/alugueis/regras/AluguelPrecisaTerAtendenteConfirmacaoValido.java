package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.funcionarios.Funcao;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaTerAtendenteConfirmacaoValido implements IRegra<Aluguel> {

	private FuncionarioServico _atendenteServico;
	
	public AluguelPrecisaTerAtendenteConfirmacaoValido(FuncionarioServico atendenteServico){
		_atendenteServico = atendenteServico;
	}
	
	@Override
	public String validar(Aluguel obj) {
		if(obj.getAtendenteConfirmacao() == null)
			return "atendente n�o informado.";
		
		Funcionario a = _atendenteServico.buscarPorID(obj.getAtendenteConfirmacao().getId());
		
		if(a == null)
			return "atendente n�o existe no sistema.";
		else if(a.getFuncao() != Funcao.Atendente && a.getFuncao() != Funcao.Gerente || !a.isAtivo())
			return "Atendente inv�lido.";
		
		return null;
	}
}
