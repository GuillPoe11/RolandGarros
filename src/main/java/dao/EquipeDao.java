package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Equipe;

@Component
public class EquipeDao extends DAO {

	/**
	 * Constructeur
	 */
	private EquipeDao() {

	}

	/**
	 * Récupération d'une equipe dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idEquipe
	 * @return l'equipe
	 */

	public Equipe recupEquipeParId(Integer idEquipe) {
		openAll();
		tx.begin();
		Equipe e = em.find(Equipe.class, idEquipe);
		tx.commit();
		closeAll();
		return e;
	}

	/**
	 * insertion d'une equipe dans la bdd
	 * 
	 * @param Equipe
	 *            l'equipe a ajouter
	 * 
	 */
	public void insererEquipe(Equipe e) {
		openAll();
		tx.begin();
		em.persist(e);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd Equipe
	 */
	public List<Equipe> recupToutesEquipes() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Equipe> lstEquipes = em.createQuery("SELECT e FROM equipes e ORDER BY e.idEquipe ASC").getResultList();
		tx.commit();
		closeAll();
		return lstEquipes;
	}

}
