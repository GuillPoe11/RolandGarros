package dao;

import java.util.List;

import entite.Equipe;

public interface EquipeDao {

	/**
	 * Récupération d'une equipe dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idEquipe
	 * @return l'equipe
	 */

	public Equipe recupEquipeParId(Integer idEquipe);

	/**
	 * insertion d'une equipe dans la bdd
	 * 
	 * @param Equipe
	 *            l'equipe a ajouter
	 * 
	 */
	public void insererEquipe(Equipe e);

	/**
	 * Retourne le contenu de la tableBdd Equipe
	 */
	public List<Equipe> recupToutesEquipes();
}
