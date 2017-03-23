package presentation;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeconnexionAction extends ActionSupport {

	private static final long serialVersionUID = 4228697399462008281L;

	public DeconnexionAction() {
	}

	public String execute(){
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		session.put("estConnecte", false);
		return "success";
	}
	
}
