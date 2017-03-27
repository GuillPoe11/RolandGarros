package metier;

import java.util.List;

import entite.Nationalite;
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
	
	/**
	 * (fonction pour recupérer un soustournoi par l'id)
	 * @return un soustournoi
	 * 
	 */
	public SousTournoi recupererSousTournoiParId(int id);
	
	/**
	 * Récupère la liste des sous-tournois en équipe
	 * 
	 * @return La liste des sous-tournois en équipe
	 */
	public List<SousTournoi> recupererTousLesSousTournoisEquipe();
	
	/**
	 * Récupère la liste des sous-tournois simples
	 * 
	 * @return La liste des sous-tournois simples
	 */
	public List<SousTournoi> recupererTousLesSousTournoisSimple();
}
