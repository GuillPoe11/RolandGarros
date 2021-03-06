package dao.interfaces;

import java.util.List;

import entite.Arbitre;

public interface ArbitreDao {

	/**
	 * Récupération d'un arbitre de la base de données par son id
	 * 
	 * @param idArbitre
	 *            l'identifiant de l'arbitre en base de données
	 * @return L'AjouterArbitre correspondant
	 */
	public Arbitre recupArbitreParId(Integer idArbitre);

	/**
	 * Récupération de la liste des arbitres dans la base de données
	 * 
	 * @return La liste des arbitres
	 */
	public List<Arbitre> recupTousLesArbitres();

	/**
	 * Récupération de la liste des 10 derniers arbitres enregistrés dans la
	 * base de données
	 * 
	 * @return La liste des 10 derniers arbitres
	 */
	public List<Arbitre> recupLesDixDerniersArbitres();

	/**
	 * Insertion d'un arbitre en base de données
	 * 
	 * @param j
	 *            L'arbitre à insérer
	 */
	public void insererArbitre(Arbitre arbitre);

}
