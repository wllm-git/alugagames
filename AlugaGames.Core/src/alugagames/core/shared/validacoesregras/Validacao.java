package alugagames.core.shared.validacoesregras;

import java.util.ArrayList;
import java.util.List;

public class Validacao<T> {
	List<IRegra<T>> regras;
	
	public Validacao(){
		regras = new ArrayList<IRegra<T>>();
	}
	
	public void adicionarRegra(IRegra<T> regra){
		regras.add(regra);
	}
	
	public List<String> validar(T obj){
		List<String> erros = new ArrayList<>();
		
		for(IRegra<T> regra : regras){
			String ret = regra.validar(obj);
			if(ret != null && !ret.isEmpty())
				erros.add(ret);
		}
		
		return erros;
	}
	
}
