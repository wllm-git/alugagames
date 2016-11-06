package alugagames.aplicacao;

import alugagames.repositorio.config.ConnectionManager;

public class AplicacaoBase {

	void beginTransaction(){
		ConnectionManager.beginTransaction();
	}
	
    void commit(){
    	ConnectionManager.commit();
    }
    
    void rollback(){
    	ConnectionManager.rollback();
    }
    
    
}
