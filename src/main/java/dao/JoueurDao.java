package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import entite.Joueur;
import entite.Nationalite;

@Component
public class JoueurDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	private static JoueurDao instance;

	/**
	 * Dao en singleton, a degager avec Spring
	 * 
	 * @return l'instance unique du Dao
	 */
	public static JoueurDao getInstance() {
		if (instance == null) {
			instance = new JoueurDao();
		}
		return instance;
	}

	/**
	 * Constructeur qui initialise le contexte de persistance
	 */
	public JoueurDao() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	/**
	 * Fermeture factory d'entity manager
	 * et fermeture entity manager
	 */
	public void closeAll() {
		em.close();
		emf.close();
	}

	/**
	 * Creation d'une instance de Joueur et ajout au contexte de persistance.
	 * 
	 * @param nomJoueur
	 * @param prenomJoueur
	 * @param sexeJoueur
	 * @param refIdNationalite
	 * @return le Joueur cree
	 */

	public Joueur getJoueur(String nomJoueur, String prenomJoueur, Character sexeJoueur, Nationalite refIdNationalite) {
		Joueur j = new Joueur(nomJoueur, prenomJoueur, sexeJoueur, refIdNationalite);
		em.persist(j);
		return j;
	}
	
	//test nationalite
	public Nationalite getNationalite(String libelleNationalite) {
		Nationalite n = new Nationalite(libelleNationalite);
		em.persist(n);
		return n;
	}

	/**
	 * Synchronise le context de persistance avec la bdd
	 * puis demarre une nouvelle transaction
	 */
	public void commit() {
		tx.commit();
		tx.begin();
	}

	/**
	 * efface un Joueur
	 * 
	 * @param j : le Joueur
	 */
	public void remove(Joueur j) {
		em.remove(j);
	}

	/**
	 * Retourne le contenu de la tableBdd joueur
	 */
	public List<Joueur> getAll() {
		return em.createQuery("SELECT j FROM joueur j ORDER BY j.nomJoueur ASC").getResultList();
	}

	/**
	 * Retourne un Joueur selectionne par son id
	 * 
	 * @param id : id Joueur recherche
	 * @return le Joueur
	 */
	public Joueur getFromId(int id) {
		return em.find(Joueur.class, id);
	}

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	public String tableToString() {
		StringBuffer result = new StringBuffer();
		result.append("Contenu de la table joueur :\n");
		for (Object p : em.createQuery("SELECT j FROM joueur j ORDER BY j.nomJoueur ASC").getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}
}
