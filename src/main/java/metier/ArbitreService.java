package metier;

import java.util.List;

import entite.Arbitre;

public interface ArbitreService {

	/**
	 * (fonction pour recupérer tous les arbitres)
	 * 
	 * @return List<Arbitre> la liste des arbitres
	 */
	public List<Arbitre> recupTousArbitres();

	/**
	 * (fonction pour recupérer un arbitre par l'id)
	 * 
	 * @param id
	 * @return Arbitre l'arbitre
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
