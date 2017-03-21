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
	 * Creation d'une instance de Court et ajout au contexte de persistance.
	 * 
	 * @param nomCourt
	 * @param numeroCourt
	 * @return le Court cree
	 */

	public Court getCourt(String nomCourt, String numeroCourt) {
		openAll();
		tx.begin();
		Court c = new Court(nomCourt, numeroCourt);
		em.persist(c);
		tx.commit();
		closeAll();
		return c;
	}

	public Court recupCourtParId(Integer idCourt) {
		openAll();
		tx.begin();
		Court c = em.find(Court.class, idCourt);
		tx.commit();
		closeAll();
		return c;
	}

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
		return em.createQuery("SELECT c FROM court c ORDER BY c.nomCourt ASC").getResultList();
	}

}
