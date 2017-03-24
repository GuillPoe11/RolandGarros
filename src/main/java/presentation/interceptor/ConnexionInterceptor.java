package presentation.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ConnexionInterceptor implements Interceptor {

	private static final long serialVersionUID = -7756808847545571536L;

	public ConnexionInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> session = inv.getInvocationContext().getSession();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getServletPath().substring(1);
		
		Object estConnecte = session.get("estConnecte");
		if (estConnecte != null) {
			if((boolean) estConnecte){
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
