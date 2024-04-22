package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConnection {
	private EntityManagerFactory emf;
	private static DatabaseConnection databaseConnection = null;

	private DatabaseConnection() {
		emf = Persistence.createEntityManagerFactory("JPA_ORM_MARIADB");
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public synchronized static DatabaseConnection getInstance() {
		if (databaseConnection == null)
			databaseConnection = new DatabaseConnection();

		return databaseConnection;
	}
}