import alugagames.repositorio.config.ConnectionManager;

public class Teste {

	public static void main(String[] args) {
		ConnectionManager.getEntityManager();
		ConnectionManager.dispose();
	}

}
