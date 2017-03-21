package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Organisateur;

@Component
public class OrganisateurDAO extends DAO {

	/**
	 * Constructeur qui initialise le contexte de persistance
	 */
	private OrganisateurDAO() {
		super();
	}

	/**
	 * ajoute un organisateur
	 * 
	 * @param o
	 *            : l'organisateur
	 */
	public void insererOrganisateur(Organisateur o) {
		openAll();
		tx.begin();
		em.persist(o);
		tx.commit();
		closeAll();
	}

	/**
	 * efface un organisateur
	 * 
	 * @param o
	 *            : l'organisateur
	 */
	public void effacer(Organisateur o) {
		em.remove(o);
	}

	/**
	 * Retourne le contenu de la tableBdd organisateur
	 */
	public List<Organisateur> recupTout() {
		return em.createQuery("SELECT j FROM organisateur j ORDER BY j.loginOrganisateur ASC").getResultList();
	}

	/**
	 * Retourne un organisateur selectionne par son id
	 * 
	 * @param id
	 *            : id organisateur recherche
	 * @return l'organisateur
	 */
	public Organisateur recupOrganisateurParId(int id) {
		return em.find(Organisateur.class, id);
	}

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	public String tableToString() {
		StringBuffer result = new StringBuffer();
		result.append("Contenu de la table organisateur :\n");
		for (Object p : em.createQuery("SELECT j FROM organisateur j ORDER BY j.loginOrganisateur ASC")
				.getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}
}
