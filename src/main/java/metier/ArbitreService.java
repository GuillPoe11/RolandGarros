package metier;

import java.util.List;

import entite.Arbitre;

public interface ArbitreService {

	/**
	 * (fonction pour recupérer toutes les Arbitre)
	 * 
	 * @return List<Arbitre>
	 */
	public List<Arbitre> recupTousArbitres();

	/**
	 * (fonction pour recupérer un Arbitre par l'id)
	 * 
	 * @param id
	 * @return Arbitre
	 */
	public Arbitre recupArbitreParId(int id);

	/**
	 * (fonction pour ajouter un arbitre)
	 * 
	 * @param nomArbitre,
	 *            prenomArbitre
	 * @return
	 */
	public void insererArbitre(String nomArbitre, String prenomArbitre);

}
