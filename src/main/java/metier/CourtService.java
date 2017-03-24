package metier;

import java.util.List;

import entite.Court;

public interface CourtService {

	/**
	 * Fonction pour récupérer tous les courts
	 * @return List<Court> la liste des courts
	 */
	public List<Court> recupTousCourts();

	/**
	 * Fonction de récupération du court par id
	 * @param id
	 * @return Court le court
	 */
	public Court recupCourtParId(int id);

	/**
	 *  Fonction d'insertion d'un terrain
	 * @param nomCourt
	 * @param numeroCourt
	 */
	public void insererCourt(String nomCourt, String numeroCourt);

}
