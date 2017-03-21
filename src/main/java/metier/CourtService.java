package metier;

import java.util.List;

import entite.Court;

public interface CourtService {

	/**
	 * Fonction pour récupérer tout les terrains
	 * @return
	 */
	public List<Court> recupTousCourts();

	/**
	 * Fonction de récupération du terrain par id
	 * @param id
	 * @return
	 */
	public Court recupCourtParId(int id);

	/**
	 *  Fonction d'insertion d'un terrain
	 * @param nomCourt
	 * @param numeroCourt
	 */
	public void insererCourt(String nomCourt, String numeroCourt);

}
