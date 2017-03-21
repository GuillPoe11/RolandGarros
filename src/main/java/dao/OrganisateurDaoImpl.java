package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Organisateur;

@Component
public class OrganisateurDaoImpl extends DAO implements OrganisateurDao {

	/**
	 * Constructeur
	 */
	private OrganisateurDaoImpl() {
		super();
	}

	/**
	 * ajoute un organisateur
	 * 
	 * @param o
	 *            : l'organisateur
	 */
	@Override
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
	@Override
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
	@Override
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
	 * Retourne une liste contenant l'organisateur si le login et le password
	 * sont valides
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Organisateur> recupConnexionOrganisateur(String login, String password) {
		openAll();
		tx.begin();
		List<Organisateur> lstOrganisateurs = em.createQuery("SELECT o FROM organisateur o WHERE loginOrganisateur = "
				+ login + "  AND passwordOrganisateur =" + password).getResultList();
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
	@Override
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
	@Override
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
