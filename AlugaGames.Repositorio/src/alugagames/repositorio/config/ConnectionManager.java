package alugagames.repositorio.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnectionManager {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;
	
	
	public static void beginTransaction(){
		createEntityManager();
		et = em.getTransaction();
		et.begin();
		
	}
	
	public static void commit(){
		if(et == null)
			return;
		et.commit();
	}
	
	public static void rollback(){
		if(et == null)
			return;
		et.rollback();
	}
	
	public static void dispose(){
		if(em == null)
			return;
		em.close();
		emf.close();
		em = null;
		emf = null;
	}
	
	private static void createEntityManager(){
		if(em != null)
			return;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		emf = Persistence.createEntityManagerFactory("hibernateconnection");
		em = emf.createEntityManager();
	}
	
	public static EntityManager getEntityManager(){
		createEntityManager();
		return em;
	}
}
