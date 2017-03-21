package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Match;
import entite.Organisateur;

@Component
public class OrganisateurDao extends DAO {

	/**
	 * Constructeur
	 */
	private OrganisateurDao() {
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
		openAll();
		tx.begin();
		em.remove(o);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd organisateur
	 */
	@SuppressWarnings("unchecked")
	public List<Organisateur> recupTousOrganisateurs() {
		openAll();
		tx.begin();
		List<Organisateur> lstOrganisateurs = em
				.createQuery("SELECT o FROM organisateur o ORDER BY o.loginOrganisateur ASC").getResultList();
		closeAll();
		return lstOrganisateurs;
	}

	/**
	 * Retourne un organisateur selectionne par son id
	 * 
	 * @param id
	 *            : id organisateur recherche
	 * @return l'organisateur
	 */
	public Organisateur recupOrganisateurParId(int id) {
		openAll();
		tx.begin();
		Organisateur o = em.find(Organisateur.class, id);
		closeAll();
		return o;
	}

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	public String tableToString() {
		StringBuffer result = new StringBuffer();
		result.append("Contenu de la table organisateur :\n");
		for (Object p : em.createQuery("SELECT o FROM organisateur o ORDER BY o.loginOrganisateur ASC")
				.getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}
}
