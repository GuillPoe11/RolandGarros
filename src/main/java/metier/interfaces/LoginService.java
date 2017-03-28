package metier.interfaces;

public interface LoginService {

	/**
	 * (fonction pour la connexion de l'organisateur)
	 * 
	 * @param loginOrganisateur,
	 * @param passwordOrganisateur
	 * 
	 * @return boolean
	 */
	public Boolean recupOrganisateurParLoginPassword(String loginOrganisateur, String passwordOrganisateur);

}
