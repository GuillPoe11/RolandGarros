package presentation.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Interceptor permettant d'empêcher un visiteur non connecté d'accéder aux
 * fonctions d'administrations
 * 
 * @author eric.poe11
 *
 */
public class ConnexionInterceptor implements Interceptor {

	private static final long serialVersionUID = -7756808847545571536L;

	public ConnexionInterceptor() {
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	/**
	 * Effectue la vérification que l'utilisateur est connecté. Ajoute en
	 * variable de session l'url que l'utilisateur voulait visiter avant d'être
	 */
	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		// Récupération de la session
		@SuppressWarnings("unchecked")
		Map<String, Object> session = inv.getInvocationContext().getSession();

		// Récupération de l'url contenue dans la requête
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getServletPath().substring(1);

		Object estConnecte = session.get("estConnecte");
		if (estConnecte != null) {
			if ((boolean) estConnecte) {
				return inv.invoke();
			} else {
				session.put("url", url);
				return "login";
			}
		} else {
			session.put("url", url);
			return "login";
		}
	}

}
