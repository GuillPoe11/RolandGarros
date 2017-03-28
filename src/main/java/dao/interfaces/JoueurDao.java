package dao.interfaces;

import java.util.List;

import entite.Joueur;

public interface JoueurDao {

	/**
	 * Récupération d'un joueur de la base de données par son id
	 * 
	 * @param idJoueur
	 *            l'identifiant du joueur en base de données
	 * @return le Joueur correspondant
	 */
	public Joueur recupJoueurParId(Integer idJoueur);

	/**
	 * Récupération de la liste des joueurs dans la base de données
	 * 
	 * @return La liste des joueurs
	 */
	public List<Joueur> recupTousLesJoueurs();

	/**
	 * Récupération de la liste des 10 derniers joueurs enregistrés dans la base
	 * de données
	 * 
	 * @return La liste des 10 derniers joueurs
	 */
	public List<Joueur> recupLesDixDerniersJoueurs();

	/**
	 * Insertion d'un joueur en base de données
	 * 
	 * @param j
	 *            Le joueur à insérer
	 */
	public void insererJoueur(Joueur j);

	/**
	 * Efface un Joueur
	 * 
	 * @param j
	 *            Le Joueur
	 */
	public void remove(Joueur j);

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	public String tableToString();
}
