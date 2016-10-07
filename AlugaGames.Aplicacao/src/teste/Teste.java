package teste;
import java.util.UUID;

import alugagames.core.clientes.Cliente;
import alugagames.repositorio.ClienteRepositorio;

public class Teste {

	public static void main(String[] args) {
		
		try {

			
			
			if(true){
				int i = 9;
			}
			
			String teste = UUID.randomUUID().toString();
			
			UUID id = UUID.fromString("08771cfb-7921-4005-9b81-3fbb92224210");
			
			Cliente c = new  ClienteRepositorio().buscarPorID(id);
			
			if(true){
				int i = 9;
			}
		} catch (Exception e) {
			if(true){
				int ip = 9;
			}
		}
		
		
		
	}

}
