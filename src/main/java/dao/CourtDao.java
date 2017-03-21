package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Court;

@Component
public class CourtDao extends DAO {

	/**
	 * Constructeur
	 */
	private CourtDao() {
	}

	/**
	 * Récupération d'un court dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idCourt
	 * @return le court
	 */

	public Court recupCourtParId(Integer idCourt) {
		openAll();
		tx.begin();
		Court c = em.find(Court.class, idCourt);
		tx.commit();
		closeAll();
		return c;
	}

	/**
	 * insertion d'un court dans la bdd
	 * 
	 * @param Court
	 *            le court a ajouter
	 * 
	 */

	public void insererCourt(Court c) {
		openAll();
		tx.begin();
		em.persist(c);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd court
	 */
	public List<Court> recupTousLesCourts() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Court> lstCourts = em.createQuery("SELECT c FROM court c ORDER BY c.nomCourt ASC").getResultList();
		tx.commit();
		closeAll();
		return lstCourts;
	}

}