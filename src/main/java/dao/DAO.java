package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class DAO {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;

	public DAO() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	/**
	 * Fermeture factory d'entity manager et fermeture entity manager
	 */
	public void closeAll() {
		em.close();
		emf.close();
	}

	/**
	 * Synchronise le context de persistance avec la bdd puis demarre une
	 * nouvelle transaction
	 */
	public void commit() {
		tx.commit();
		tx.begin();
	}

}
