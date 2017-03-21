package metier;

public interface LoginService {
	
	/**
	 * (fonction pour la connexion de l'organisateur)
	 * 
	 * @param loginOrganisateur,
	 *            passwordOrganisateur
	 * 
	 * @return boolean
	 */
	public Boolean recupOrganisateurParLoginPassword(String loginOrganisateur, String passwordOrganisateur);


}
