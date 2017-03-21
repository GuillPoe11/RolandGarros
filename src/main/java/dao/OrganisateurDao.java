package dao;

import java.util.List;

import entite.Organisateur;

public interface OrganisateurDao {

	/**
	 * ajoute un organisateur
	 * 
	 * @param o
	 *            : l'organisateur
	 */
	public void insererOrganisateur(Organisateur o);

	/**
	 * efface un organisateur
	 * 
	 * @param o
	 *            : l'organisateur
	 */

	public void effacer(Organisateur o);

	/**
	 * Retourne le contenu de la tableBdd organisateur
	 */

	public List<Organisateur> recupTousOrganisateurs();

	/**
	 * Retourne un organisateur selectionne par son id
	 * 
	 * @param id
	 *            : id organisateur recherche
	 * @return l'organisateur
	 */
	public Organisateur recupOrganisateurParId(int id);

	/**
	 * Affiche le contenu de la table
	 * 
	 * @return contenu de la table
	 */
	public String tableToString();
	
	/**
	 * Retourne une liste contenant l'organisateur si le login et le password
	 * sont valides
	 */
	public List<Organisateur> recupConnexionOrganisateur(String login,String password);
}
