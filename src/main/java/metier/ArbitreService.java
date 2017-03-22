package metier;

import java.util.List;

import entite.Arbitre;

public interface ArbitreService {

	/**
	 * (fonction pour recupérer toutes les AjouterArbitre)
	 * 
	 * @return List<AjouterArbitre>
	 */
	public List<Arbitre> recupTousArbitres();

	/**
	 * (fonction pour recupérer un AjouterArbitre par l'id)
	 * 
	 * @param id
	 * @return AjouterArbitre
	 */
	public Arbitre recupArbitreParId(int id);

	/**
	 * (fonction pour ajouter un arbitre)
	 * 
	 * @param nomArbitre,
	 * @param prenomArbitre
	 * 
	 */
	public void insererArbitre(String nomArbitre, String prenomArbitre);

}
