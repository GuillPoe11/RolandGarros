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
public class JoueurDao extends DAO {

	/**
	 * Constructeur qui initialise le contexte de persistance
	 */
	private JoueurDao() {
		super();
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
		openAll();
		tx.begin();
		Joueur j = new Joueur(nomJoueur, prenomJoueur, sexeJoueur, refIdNationalite);
		em.persist(j);
		tx.commit();
		closeAll();
		return j;
	}

	// test nationalite
	public Nationalite getNationalite(Integer idNationalite) {
		openAll();
		tx.begin();
		Nationalite n = em.find(Nationalite.class, idNationalite);
		tx.commit();
		closeAll();
		return n;
	}

	public void insererJoueur(Joueur j){
		openAll();
		tx.begin();
		em.persist(j);
		tx.commit();
		closeAll();
	}
	
	/**
	 * efface un Joueur
	 * 
	 * @param j
	 *            : le Joueur
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
	 * @param id
	 *            : id Joueur recherche
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
