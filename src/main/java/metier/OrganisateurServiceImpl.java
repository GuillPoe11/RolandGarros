package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrganisateurDao;
import entite.Organisateur;

@Service
public class OrganisateurServiceImpl implements OrganisateurService {

	@Autowired
	private OrganisateurDao nDao;

	public OrganisateurServiceImpl() {
	}

	@Override
	public List<Organisateur> recupTousOrganisateur() {
		return nDao.recupTousOrganisateurs();
	}

	@Override
	public Organisateur recupOrganisateurParId(int id) {
		return nDao.recupOrganisateurParId(id);
	}

	@Override
	public void insererOrganisateur(String loginOrganisateur, String passwordOrganisateur) {
		nDao.insererOrganisateur(new Organisateur(loginOrganisateur, passwordOrganisateur));
	}

}
