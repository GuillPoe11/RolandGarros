package metier.interfaces;

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
	 * (fonction pour recupérer les 10 derniers arbitres)
	 * 
	 * @return List<Arbitre> la liste des 10 derniers arbitres
	 */
	public List<Arbitre> recupLesDixDerniersArbitres();

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
