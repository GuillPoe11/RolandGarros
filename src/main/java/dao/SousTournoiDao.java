package dao;

import java.util.List;

import entite.SousTournoi;

public interface SousTournoiDao {

	/**
	 * Récupération d'un sousTournoi dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idSousTournoi
	 * @return l'equipe
	 */

	public SousTournoi recupSousTournoiParId(Integer idSousTournoi);

	/**
	 * insertion d'un ousTournoi dans la bdd
	 * 
	 * @param SousTournoi
	 *            le sousTournoi a ajouter
	 * 
	 */
	public void insererSousTournoi(SousTournoi st);

	/**
	 * Retourne le contenu de la tableBdd SousTournoi
	 */
	public List<SousTournoi> recupTousLesSousTournois();
}
