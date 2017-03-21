package dao;

import java.util.List;

import entite.Court;

public interface CourtDao {

	/**
	 * Récupération d'un court dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idCourt
	 * @return le court
	 */

	public Court recupCourtParId(Integer idCourt);

	/**
	 * insertion d'un court dans la bdd
	 * 
	 * @param Court
	 *            le court a ajouter
	 * 
	 */

	public void insererCourt(Court c);

	/**
	 * Retourne le contenu de la tableBdd court
	 */
	public List<Court> recupTousLesCourts();
}
