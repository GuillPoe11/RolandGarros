package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Joueur;

@Component
public class JoueurDaoImpl extends DAO implements JoueurDao {

	/**
	 * Constructeur
	 */
	private JoueurDaoImpl() {
		super();
	}

	/**
	 * Récupération d'un joueur de la base de données par son id
	 * 
	 * @param idJoueur
	 *            l'identifiant du joueur en base de données
	 * @return le Joueur correspondant
	 */
	@Override
	public Joueur recupJoueurParId(Integer idJoueur) {
		openAll();
		tx.begin();
		Joueur j = em.find(Joueur.class, idJoueur);
		tx.commit();
		closeAll();
		return j;
	}
	
	
	

	/**
	 * Récupération de la liste des joueurs dans la base de données
	 * 
	 * @return La liste des joueurs
	 */
	@Override
	public List<Joueur> recupTousLesJoueurs() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Joueur> lstJoueurs = em.createQuery("SELECT j FROM joueur j ORDER BY j.nomJoueur ASC").getResultList();
		tx.commit();
		closeAll();
		return lstJoueurs;
	}

	/**
	 * Insertion d'un joueur en base de données
	 * 
	 * @param j
	 *            Le joueur à insérer
	 */
	@Override
	public void insererJoueur(Joueur j) {
		openAll();
		tx.begin();
		em.persist(j);
		tx.commit();
		closeAll();
	}

	/**
	 * Efface un Joueur
	 * 
	 * @param j
	 *            Le Joueur
	 */
	@Override
	public void remove(Joueur j) {
		openAll();
		tx.begin();
		em.remove(j);
		tx.commit();
		closeAll();
	}

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	@Override
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