package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Nationalite;

@Component
public class NationaliteDao extends DAO {

	/**
	 * Constructeur
	 */
	private NationaliteDao() {

	}

	/**
	 * Récupération d'une nationalite dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idNationalite
	 * @return la nationalite
	 */

	public Nationalite recupNationaliteParId(Integer idNationalite) {
		openAll();
		tx.begin();
		Nationalite n = em.find(Nationalite.class, idNationalite);
		tx.commit();
		closeAll();
		return n;
	}

	/**
	 * insertion d'une nationalite dans la bdd
	 * 
	 * @param Equipe
	 *            nationalite a ajouter
	 * 
	 *            ### normalement pas utilisé, sauf si nouveaux pays ?
	 */
	public void insererNationalite(Nationalite n) {
		openAll();
		tx.begin();
		em.persist(n);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd Nationalite
	 */
	public List<Nationalite> recupToutesNationalites() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Nationalite> lstNationalites = em
				.createQuery("SELECT n FROM nationalites n ORDER BY n.libelleNationalite ASC").getResultList();
		tx.commit();
		closeAll();
		return lstNationalites;
	}

}
