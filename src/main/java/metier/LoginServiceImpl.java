package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.OrganisateurDao;
import entite.Organisateur;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private OrganisateurDao nDao;

	/**
	 * Constructeurs
	 */
	public LoginServiceImpl() {
	}

	/**
	 * (fonction pour la connexion de l'organisateur)
	 * 
	 */
	@Override
	public Boolean recupOrganisateurParLoginPassword(String loginOrganisateur, String passwordOrganisateur) {
		if (nDao.recupConnexionOrganisateur(loginOrganisateur, passwordOrganisateur).size() == 1) {
			return true;
		}
		return false;
	}
}
