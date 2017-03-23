package presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Organisateur;
import metier.OrganisateurService;

public class ConnexionAction extends ActionSupport {

	private static final long serialVersionUID = 7796703197715898108L;

	private Organisateur organisateur;

	@Autowired
	private OrganisateurService organisateurService;

	public String seConnecter() {
		if (loginEtMotDePAsseOk()) {
			return "connecte";
		} else {
			return "success";
		}
	}

	private boolean loginEtMotDePAsseOk() {
		boolean res = false;
		List<Organisateur> lstOrganisateurs = organisateurService.recupTousOrganisateur();
		for (Organisateur orga : lstOrganisateurs) {
			if (orga.getLoginOrganisateur().equals(organisateur.getLoginOrganisateur())
					&& orga.getPasswordOrganisateur().equals(organisateur.getPasswordOrganisateur())) {
				res = true;
			}
		}
		return res;
	}

	public Organisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}

}
