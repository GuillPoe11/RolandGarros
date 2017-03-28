package dao.implementations;

import java.util.List;

import org.springframework.stereotype.Component;

import dao.DAO;
import dao.interfaces.SousTournoiDao;
import entite.SousTournoi;

@Component
public class SousTournoiDaoImpl extends DAO implements SousTournoiDao {

	/**
	 * Constructeur
	 */
	private SousTournoiDaoImpl() {
	}

	/**
	 * Récupération d'un sousTournoi dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idSousTournoi
	 * @return l'equipe
	 */
	@Override
	public SousTournoi recupSousTournoiParId(Integer idSousTournoi) {
		openAll();
		tx.begin();
		SousTournoi st = em.find(SousTournoi.class, idSousTournoi);
		tx.commit();
		closeAll();
		return st;
	}

	/**
	 * insertion d'un SousTournoi dans la bdd
	 * 
	 * @param SousTournoi
	 *            le sousTournoi a ajouter
	 * 
	 */
	@Override
	public void insererSousTournoi(SousTournoi st) {
		openAll();
		tx.begin();
		em.persist(st);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd SousTournoi
	 */
	@Override
	public List<SousTournoi> recupTousLesSousTournois() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<SousTournoi> lstSousTournois = em
				.createQuery("SELECT st FROM SousTournoi st ORDER BY st.idSousTournoi ASC").getResultList();
		tx.commit();
		closeAll();
		return lstSousTournois;
	}

	@Override
	public List<SousTournoi> recupTousLesSousTournoisEquipe() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<SousTournoi> lstSousTournois = em
				.createQuery(
						"SELECT st FROM SousTournoi st WHERE st.typeSousTournoi = 'E' ORDER BY st.idSousTournoi ASC")
				.getResultList();
		tx.commit();
		closeAll();
		return lstSousTournois;
	}

	@Override
	public List<SousTournoi> recupTousLesSousTournoisSimple() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<SousTournoi> lstSousTournois = em
				.createQuery(
						"SELECT st FROM SousTournoi st WHERE st.typeSousTournoi = 'S' ORDER BY st.idSousTournoi ASC")
				.getResultList();
		tx.commit();
		closeAll();
		return lstSousTournois;
	}

}
