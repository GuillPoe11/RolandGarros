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
		openAll();
		tx.begin();
		String hqlUpdate = "UPDATE Match m SET m.score1 = :newScore1, m.score2 = :newScore2, m.dureeMatch = :duree,"
				+ " m.dateMatch = :date WHERE m.idMatch = :idMatch";

		em.createQuery(hqlUpdate).setParameter("newScore1", m.getScore1()).setParameter("newScore2", m.getScore2())
				.setParameter("idMatch", m.getIdMatch()).setParameter("duree", m.getDureeMatch())
				.setParameter("date", m.getDateMatch()).executeUpdate();

		System.out.println(m.getScore1());
		System.out.println(m.getScore2());

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
	 * Retourne le contenu de la tableBdd match dont les matchs ne sont pas
	 * entièrement rempli
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Match> recupTousMatchsAModifie() {
		openAll();
		tx.begin();
		System.out.println("here");
		List<Match> lstMatchs = em.createQuery("SELECT m FROM Match m WHERE m.dureeMatch=null ORDER BY m.dateMatch DESC")
				.getResultList();
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

	@Override
	@SuppressWarnings("unchecked")
	public List<Match> recupLesDixDerniersMatchsSimples() {
		openAll();
		tx.begin();
		List<Match> lstDixDerniersMatchs = em
				.createQuery(
						"SELECT m FROM Match m WHERE m.sousTournoi.typeSousTournoi = 'S' ORDER BY m.dateMatch DESC")
				.setMaxResults(10).getResultList();
		closeAll();
		return lstDixDerniersMatchs;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Match> recupLesDixDerniersMatchsEnEquipe() {
		openAll();
		tx.begin();
		List<Match> lstDixDerniersMatchs = em
				.createQuery(
						"SELECT m FROM Match m WHERE m.sousTournoi.typeSousTournoi = 'E' ORDER BY m.dateMatch DESC")
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
