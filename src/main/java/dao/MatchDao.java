package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Match;

@Component
public class MatchDao extends DAO {

	/**
	 * Constructeur
	 */
	private MatchDao() {
		super();
	}

	/**
	 * ajoute un match
	 * 
	 * @param o
	 *            : l'organisateur
	 */
	public void insererMatch(Match o) {
		openAll();
		tx.begin();
		em.persist(o);
		tx.commit();
		closeAll();
	}

	/**
	 * efface un match
	 * 
	 * @param o
	 *            : match
	 */
	public void effacer(Match o) {
		openAll();
		tx.begin();
		em.remove(o);
		tx.commit();
		closeAll();
	}

	/**
	 * modifie un match
	 * 
	 * @param o
	 *            : match
	 */
	public void modifier(Match o) {
		openAll();
		tx.begin();
		Match matchModifier = recupMatchParId(o.getIdMatch());
		matchModifier.setArbitre(o.getArbitre());
		matchModifier.setCourt(o.getCourt());
		matchModifier.setDate(o.getDate());
		matchModifier.setDuree(o.getDuree());
		matchModifier.setEquipe1(o.getEquipe1());
		matchModifier.setEquipe2(o.getEquipe2());
		matchModifier.setJoueur1(o.getJoueur1());
		matchModifier.setJoueur2(o.getJoueur2());
		matchModifier.setScore1(o.getScore1());
		matchModifier.setScore2(o.getScore2());
		matchModifier.setSousTournoi(o.getSousTournoi());
		em.persist(matchModifier);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd match
	 */
	@SuppressWarnings("unchecked")
	public List<Match> recupTout() {
		openAll();
		tx.begin();
		List<Match> lstMatchs = em.createQuery("SELECT m FROM match m ORDER BY m.date DESC").getResultList();
		closeAll();
		return lstMatchs;
	}

	/**
	 * Retourne un match selectionne par son id
	 * 
	 * @param id
	 *            : id match recherche
	 * @return match
	 */
	public Match recupMatchParId(int id) {
		openAll();
		tx.begin();
		Match m = em.find(Match.class, id);
		closeAll();
		return m;
	}

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	public String tableToString() {
		StringBuffer result = new StringBuffer();
		result.append("Contenu de la table Match :\n");
		for (Object p : em.createQuery("SELECT m FROM match m ORDER BY m.date DESC").getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}
}
