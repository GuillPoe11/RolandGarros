package metier;

import java.util.List;

import entite.Arbitre;

public interface ArbitreService {

	/**
	 * (fonction pour recupérer toutes les Arbitre)
	 * 
	 */
	public List<Arbitre> recupTousArbitres();

	/**
	 * (fonction pour recupérer un Arbitre par l'id)
	 * 
	 */
	public Arbitre recupArbitreParId(int id);

	/**
	 * (fonction pour ajouter un arbitre)
	 * 
	 */
	public void insererCourt(String nomArbitre, String prenomArbitre);

}
