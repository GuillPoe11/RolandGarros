package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.OrganisateurDao;
import entite.Organisateur;

@Component
public class OrganisateurServiceImpl implements OrganisateurService {

	@Autowired
	private OrganisateurDao nDao;

	/**
	 * Constructeurs
	 */
	public OrganisateurServiceImpl() {
	}

	/**
	 * (fonction pour recupérer toutes les Organisateurs)
	 * 
	 */
	@Override
	public List<Organisateur> recupTousOrganisateur() {
		return nDao.recupTousOrganisateurs();
	}

	/**
	 * (fonction pour recupérer un Organisateur par l'id)
	 * 
	 */
	@Override
	public Organisateur recupOrganisateurParId(int id) {
		return nDao.recupOrganisateurParId(id);
	}

	/**
	 * (fonction pour ajouter un Organisateur)
	 * 
	 */
	@Override
	public void insererOrganisateur(String loginOrganisateur, String passwordOrganisateur) {
		nDao.insererOrganisateur(new Organisateur(loginOrganisateur, passwordOrganisateur));
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
