package alugagames.core.alugueis.regras;

import alugagames.core.alugueis.Aluguel;
import alugagames.core.funcionarios.Funcionario;
import alugagames.core.funcionarios.FuncionarioServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class AluguelPrecisaTerAtendenteValido implements IRegra<Aluguel> {

	private FuncionarioServico _atendenteServico;
	
	public AluguelPrecisaTerAtendenteValido(FuncionarioServico atendenteServico){
		_atendenteServico = atendenteServico;
	}
	
	@Override
	public String validar(Aluguel obj) {
		if(obj.getAtendente() == null)
			return "atendente n�o informado.";
		
		Funcionario a = _atendenteServico.buscarPorId(obj.getAtendente().getId());
		
		if(a == null)
			return "atendente n�o existe no sistema.";
		
		return null;
	}
}
