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
	 * modifie score1,score2 et duree d'un match
	 * 
	 * @param m
	 *            : match
	 */
	@Override
	public void modifier(Match m) {

		// gnééé ?? pourquoi recréér un truc qu'on a déjà ??
		// Match matchModifier = recupMatchParId(m.getIdMatch());
		// matchModifier.setArbitre(m.getArbitre());
		// matchModifier.setCourt(m.getCourt());
		// matchModifier.setDateMatch(m.getDateMatch());
		// matchModifier.setDureeMatch(m.getDureeMatch());
		// matchModifier.setEquipe1(m.getEquipe1());
		// matchModifier.setEquipe2(m.getEquipe2());
		// matchModifier.setJoueur1(m.getJoueur1());
		// matchModifier.setJoueur2(m.getJoueur2());
		// matchModifier.setScore1(m.getScore1());
		// matchModifier.setScore2(m.getScore2());
		// matchModifier.setSousTournoi(m.getSousTournoi());

		openAll();
		tx.begin();
		String hqlUpdate = "UPDATE Match m SET m.score1 = :newScore1, m.score2 = :newScore2, m.dureeMatch = :duree WHERE m.idMatch = :idMatch";

		em.createQuery(hqlUpdate).setParameter("newScore1", m.getScore1()).setParameter("newScore2", m.getScore2())
				.setParameter("idMatch", m.getIdMatch()).setParameter("duree", m.getDureeMatch()).executeUpdate();

		System.out.println(m.getScore1());
		System.out.println(m.getScore2());

		// em.merge(matchModifier);

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
	 * Retourne le contenu des 10 derniers matchs enregistrés dans la tableBdd
	 * match
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Match> recupLesDixDerniersMatchs() {
		openAll();
		tx.begin();
		List<Match> lstDixDerniersMatchs = em.createQuery("SELECT m FROM Match m ORDER BY m.dateMatch DESC")
				.setMaxResults(10).getResultList();
		closeAll();
		return lstDixDerniersMatchs;
	}

	/**
	 * Retourne le contenu de la tableBdd match pour chaque Sous-Tournoi
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Match> recupTousMatchsPourUnSousTournoi(SousTournoi sousTournoi) {
		openAll();
		tx.begin();
		List<Match> lstMatchs = em.createQuery("SELECT m FROM Match m WHERE idTournoi='"
				+ sousTournoi.getIdSousTournoi() + "' ORDER BY m.dateMatch DESC").getResultList();
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
