package metier;

import java.util.List;

import entite.Organisateur;

public interface OrganisateurService {

	/**
	 * (fonction pour recupérer toutes les Organisateurs)
	 * 
	 * @return List<Organisateur>
	 */
	public List<Organisateur> recupTousOrganisateur();

	/**
	 * (fonction pour recupérer un Organisateur par l'id)
	 * 
	 * @param id
	 * @return Organisateur
	 */
	public Organisateur recupOrganisateurParId(int id);

	/**
	 * (fonction pour ajouter un Organisateur)
	 * 
	 * @param loginOrganisateur,
	 * @param passwordOrganisateur
	 * 
	 */
	public void insererOrganisateur(String loginOrganisateur, String passwordOrganisateur);

}
