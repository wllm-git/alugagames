package alugagames.core.os.regras;

import alugagames.core.funcionarios.Funcao;
import alugagames.core.os.OrdemServico;
import alugagames.core.shared.validacoesregras.IRegra;

public class OrdemServicoPrecisaTerTecnicoValido implements IRegra<OrdemServico> {

	@Override
	public String validar(OrdemServico obj) {
		if(obj.getTecnico() == null)
			return "T�cnico n�o informado";
		else if(obj.getTecnico().getFuncao() != Funcao.Tecnico)
			return "T�cnico inv�lido.";
		
		return null;
	}
}
