package presentation;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action servant à déconnecter l'utilisateur
 * 
 * @author eric.poe11
 *
 */
public class DeconnexionAction extends ActionSupport {

	private static final long serialVersionUID = 4228697399462008281L;

	public DeconnexionAction() {
	}

	/**
	 * Passe la variable de session permettant de savoir qu'un utilisateur est
	 * connecté à falser.
	 */
	public String execute() {
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		session.put("estConnecte", false);
		return "success";
	}

}
