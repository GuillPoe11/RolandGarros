package presentation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entite.Organisateur;
import metier.OrganisateurService;

/**
 * Action qui permet de gérer la connexion au site.
 * 
 * @author eric.poe11
 *
 */
public class ConnexionAction extends ActionSupport {

	private static final long serialVersionUID = 7796703197715898108L;

	private Organisateur organisateur;

	private String msgForm;
	private String typeMsgForm;

	@Autowired
	private OrganisateurService organisateurService;

	private String url;

	/**
	 * Vérifie que le login et le mot de passe entrés par l'utilisateur sont
	 * corrects
	 * 
	 * @return "connecte" si les identifiants osont corrects, "success" sinon.
	 */
	@SuppressWarnings("unchecked")
	public String seConnecter() {
		if (validation() && loginEtMotDePAsseOk()) {
			// On ajoute une variable de session qui permet de savoir que
			// l'utilisatur est connecté
			Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
			session.put("estConnecte", true);
			return "connecte";
		} else {
			return "success";
		}
	}

	/**
	 * Appelle le service de connexion pour vérifier la correspondance entre le
	 * login et le mot de passe. S'assure aussi que l'utilisateur pourra accéder
	 * directement à la page vers laquelle il voulait aller avant d'arriver à la
	 * page de connexion.
	 * 
	 * @return true si les identifiants sont corrects, false sinon.
	 */
	private boolean loginEtMotDePAsseOk() {
		boolean res = false;
		List<Organisateur> lstOrganisateurs = organisateurService.recupTousOrganisateur();
		for (Organisateur orga : lstOrganisateurs) {
			if (orga.getLoginOrganisateur().equals(organisateur.getLoginOrganisateur())
					&& orga.getPasswordOrganisateur().equals(organisateur.getPasswordOrganisateur())) {
				// Récupère l'url que l'utilisateur désirait consulter avant
				// d'arriver à la page de connexion
				@SuppressWarnings("unchecked")
				Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
				url = (String) session.get("url");
				session.remove("url");
				if(url == null){
					url = "Admin.action";
				}
				res = true;
			}
		}
		return res;
	}

	/**
	 * Vérifie que les champs du formulaire sont remplis
	 * @return true si les champs sont remplis, false sinon
	 */
	private boolean validation() {
		boolean valide = true;
		if (organisateur.getLoginOrganisateur() != null && organisateur.getLoginOrganisateur().length() == 0) {
			msgForm = "Veuillez entrez votre identifiant";
			typeMsgForm = "alert alert-danger";
			valide = false;
		} else if (organisateur.getPasswordOrganisateur() != null
				&& organisateur.getPasswordOrganisateur().length() == 0) {
			msgForm = "Veuillez entrez votre mot de passe";
			typeMsgForm = "alert alert-danger";
			valide = false;
		}
		return valide;
	}

	public Organisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsgForm() {
		return msgForm;
	}

	public void setMsgForm(String msgForm) {
		this.msgForm = msgForm;
	}

	public String getTypeMsgForm() {
		return typeMsgForm;
	}

	public void setTypeMsgForm(String typeMsgForm) {
		this.typeMsgForm = typeMsgForm;
	}

}
