package metier;

import java.util.List;

import entite.SousTournoi;

public interface SousTournoiService {

	/**
	 * Récupère un sous-tournoi en fonction de son nom
	 * 
	 * @param nomSousTournoi
	 *            Le nom du sous-tournoi
	 * @return Le sous-tournoi désiré
	 */
	public SousTournoi recupererSousTournoi(String nomSousTournoi);

	/**
	 * Récupère la liste des sous-tournois
	 * 
	 * @return La liste des sous-tournoi
	 */
	public List<SousTournoi> recupererTousLesSousTournois();
}
