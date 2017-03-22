package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Arbitre;

@Component
public class ArbitreDaoImpl extends DAO implements ArbitreDao {

	/**
	 * Constructeur
	 */
	public ArbitreDaoImpl() {
	}

	/**
	 * Récupération d'un arbitre de la base de données par son id
	 * 
	 * @param idArbitre
	 *            l'identifiant de l'arbitre en base de données
	 * @return L'AjouterArbitre correspondant
	 */
	@Override
	public Arbitre recupArbitreParId(Integer idArbitre) {
		openAll();
		tx.begin();
		Arbitre arbitre = em.find(Arbitre.class, idArbitre);
		tx.commit();
		closeAll();
		return arbitre;
	}

	/**
	 * Récupération de la liste des arbitres dans la base de données
	 * 
	 * @return La liste des arbitres
	 */
	@Override
	public List<Arbitre> recupTousLesArbitres() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Arbitre> lstArbitres = em.createQuery("SELECT a FROM Arbitre a ORDER BY a.nomArbitre ASC").getResultList();
		tx.commit();
		closeAll();
		return lstArbitres;
	}

	/**
	 * Insertion d'un arbitre en base de données
	 * 
	 * @param j
	 *            L'arbitre à insérer
	 */
	@Override
	public void insererArbitre(Arbitre arbitre) {
		openAll();
		tx.begin();
		em.persist(arbitre);
		tx.commit();
		closeAll();
	}

}
