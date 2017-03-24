package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import entite.Equipe;

@Component
public class EquipeDaoImpl extends DAO implements EquipeDao {

	/**
	 * Constructeur
	 */
	private EquipeDaoImpl() {

	}

	/**
	 * Récupération d'une equipe dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idEquipe
	 * @return l'equipe
	 */
	@Override
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
	@Override
	public void insererEquipe(Equipe e) {
		openAll();
		tx.begin();
		em.persist(e);
		tx.commit();
		closeAll();
	}

	/**
	 * Retourne le contenu de la tableBdd Equipe
	 * @return la liste des equipes
	 */
	@Override
	public List<Equipe> recupToutesEquipes() {
		openAll();
		tx.begin();
		@SuppressWarnings("unchecked")
		List<Equipe> lstEquipes = em.createQuery("SELECT e FROM Equipe e ORDER BY e.idEquipe ASC").getResultList();
		tx.commit();
		closeAll();
		return lstEquipes;
	}

	@Override
	public List<Equipe> recupLes10DernieresEquipes() {
		// TODO Auto-generated method stub
		return null;
	}

}
