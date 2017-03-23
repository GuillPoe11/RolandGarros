package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Match;
import entite.SousTournoi;

@Component
public class MatchDaoImpl extends DAO implements MatchDao {

	/**
	 * Constructeur
	 */
	private MatchDaoImpl() {
		super();
	}

	/**
	 * ajoute un match
	 * 
	 * @param m
	 *            : match
	 */
	@Override
	public void insererMatch(Match m) {
		openAll();
		tx.begin();
		em.persist(m);
		tx.commit();
		closeAll();
	}

	/**
	 * efface un match
	 * 
	 * @param m
	 *            : match
	 */
	@Override
	public void effacer(Match m) {
		openAll();
		tx.begin();
		em.remove(m);
		tx.commit();
		closeAll();
	}

	/**
	 * modifie un match
	 * 
	 * @param m
	 *            : match
	 */
	@Override
	public void modifier(Match m) {
		openAll();
		tx.begin();
		Match matchModifier = recupMatchParId(m.getIdMatch());
		matchModifier.setArbitre(m.getArbitre());
		matchModifier.setCourt(m.getCourt());
		matchModifier.setDate(m.getDate());
		matchModifier.setDuree(m.getDuree());
		matchModifier.setEquipe1(m.getEquipe1());
		matchModifier.setEquipe2(m.getEquipe2());
		matchModifier.setJoueur1(m.getJoueur1());
		matchModifier.setJoueur2(m.getJoueur2());
		matchModifier.setScore1(m.getScore1());
		matchModifier.setScore2(m.getScore2());
		matchModifier.setSousTournoi(m.getSousTournoi());
		em.persist(matchModifier);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd match
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Match> recupTousMatchs() {
		openAll();
		tx.begin();
		List<Match> lstMatchs = em.createQuery("SELECT m FROM Match m ORDER BY m.dateMatch DESC").getResultList();
		closeAll();
		return lstMatchs;
	}
	
	/**
	 * Retourne le contenu de la tableBdd match
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Match> recupTousMatchsPourUnSousTournoi(SousTournoi sousTournoi) {
		openAll();
		tx.begin();
		List<Match> lstMatchs = em.createQuery("SELECT m FROM Match m WHERE idTournoi='"+sousTournoi.getIdSousTournoi()+"' ORDER BY m.dateMatch DESC").getResultList();
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
	@Override
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
		for (Object p : em.createQuery("SELECT m FROM Match m ORDER BY m.dateMatch DESC").getResultList()) {
			result.append(p);
			result.append("\n");
		}
		return result.toString();
	}
}
