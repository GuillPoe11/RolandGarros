package metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.OrganisateurDao;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private OrganisateurDao nDao;

	public LoginServiceImpl() {
	}

	@Override
	public Boolean recupOrganisateurParLoginPassword(String loginOrganisateur, String passwordOrganisateur) {
		if (nDao.recupConnexionOrganisateur(loginOrganisateur, passwordOrganisateur).size() == 1) {
			return true;
		}
		return false;
	}
}
