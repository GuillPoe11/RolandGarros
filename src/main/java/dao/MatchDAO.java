package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Match;

@Component
public class MatchDAO extends DAO {

	/**
	 * Constructeur qui initialise le contexte de persistance
	 */
	private MatchDAO() {
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
		em.remove(o);
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
		matchModifier.setScore(o.getScore());
		matchModifier.setScore2(o.getScore2());
		matchModifier.setSousTournoi(o.getSousTournoi());
		em.persist(matchModifier);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd match
	 */
	public List<Match> recupTout() {
		return em.createQuery("SELECT j FROM match j ORDER BY j.date DESC").getResultList();
	}

	/**
	 * Retourne un match selectionne par son id
	 * 
	 * @param id
	 *            : id match recherche
	 * @return match
	 */
	public Match recupMatchParId(int id) {
		return em.find(Match.class, id);
	}

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	public String tableToString() {
		StringBuffer result = new StringBuffer();
		result.append("Contenu de la table Match :\n");
		for (Object p : em.createQuery("SELECT j FROM match j ORDER BY j.date DESC").getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}
}
