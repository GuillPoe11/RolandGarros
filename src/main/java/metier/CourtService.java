package metier;

import java.util.List;

import entite.Court;

public interface CourtService {

	/**
	 * Fonction pour récupérer tout les terrains
	 * @return List<Court>
	 */
	public List<Court> recupTousCourts();

	/**
	 * Fonction de récupération du terrain par id
	 * @param id
	 * @return Court
	 */
	public Court recupCourtParId(int id);

	/**
	 *  Fonction d'insertion d'un terrain
	 * @param nomCourt
	 * @param numeroCourt
	 */
	public void insererCourt(String nomCourt, String numeroCourt);

}
