package persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;


public class Conexion {
	private static Conexion instancia = null;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	private Conexion() {}
	
	public static Conexion getInstancia() {
		if(instancia == null) {
			instancia = new Conexion();
			
			emf = Persistence.createEntityManagerFactory("Portafolio");
			em = emf.createEntityManager();
		}
		return instancia;
	}
	
	public EntityManager getEntityManager() {
		return Conexion.em;
	}
	
	public void close() {
		Conexion.em.close();
		Conexion.emf.close();
	}

}