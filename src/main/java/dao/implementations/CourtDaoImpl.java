package dao.implementations;

import java.util.List;

import org.springframework.stereotype.Component;

import dao.DAO;
import dao.interfaces.CourtDao;
import entite.Court;

@Component
public class CourtDaoImpl extends DAO implements CourtDao {

	/**
	 * Constructeur
	 */
	private CourtDaoImpl() {
	}

	/**
	 * Récupération d'un court dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idCourt
	 * @return le court
	 */
	@Override
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
	@Override
	public void insererCourt(Court c) {
		openAll();
		tx.begin();
		em.persist(c);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd court
	 * 
	 * @return la liste des courts
	 */
	@Override
	public List<Court> recupTousLesCourts() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Court> lstCourts = em.createQuery("SELECT c FROM Court c ORDER BY c.nomCourt ASC").getResultList();
		tx.commit();
		closeAll();
		return lstCourts;
	}

	/**
	 * Retourne les 10 derniers courts rentrés dans la tableBdd court
	 * 
	 * @return la liste des 10 derniers courts
	 */
	@Override
	public List<Court> recupLesDixDerniersCourts() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Court> lstDixCourts = em.createQuery("SELECT c FROM Court c ORDER BY c.idCourt DESC").setMaxResults(10)
				.getResultList();
		tx.commit();
		closeAll();
		return lstDixCourts;
	}

}
