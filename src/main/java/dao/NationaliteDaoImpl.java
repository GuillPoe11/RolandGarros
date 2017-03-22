package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Nationalite;

@Component
public class NationaliteDaoImpl extends DAO implements NationaliteDao {

	/**
	 * Constructeur
	 */
	private NationaliteDaoImpl() {

	}

	/**
	 * Récupération d'une nationalite dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idNationalite
	 * @return la nationalite
	 */
	@Override
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
	@Override
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
	@Override
	public List<Nationalite> recupToutesNationalites() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Nationalite> lstNationalites = em
				.createQuery("SELECT n FROM Nationalite n ORDER BY n.libelleNationalite ASC").getResultList();
		tx.commit();
		closeAll();
		return lstNationalites;
	}

}
