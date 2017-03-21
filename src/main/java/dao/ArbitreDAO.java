package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Arbitre;

@Component
public class ArbitreDAO extends DAO {

	/**
	 * Constructeur
	 */
	public ArbitreDAO() {
	}
	
	/**
	 * Récupération d'un arbitre de la base de données par son id
	 * 
	 * @param idArbitre
	 *            l'identifiant de l'arbitre en base de données
	 * @return L'Arbitre correspondant
	 */
	public Arbitre recupArbitreParID(Integer idArbitre){
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
	public List<Arbitre> recupTousLesArbitres() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Arbitre> lstArbitres = em.createQuery("SELECT a FROM arbitre a ORDER BY a.nomArbitre ASC").getResultList();
		tx.commit();
		closeAll();
		return lstArbitres;
	}

	/**
	 * Insertion d'une instance d'arbitre en base de données
	 * 
	 * @param j
	 *            L'arbitre à insérer
	 */
	public void insererArbitre(Arbitre arbitre) {
		openAll();
		tx.begin();
		em.persist(arbitre);
		tx.commit();
		closeAll();
	}

}
