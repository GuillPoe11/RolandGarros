package presentation.interceptor;

import java.util.Map;

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
		
		Object estConnecte = session.get("estConnecte");
		if (estConnecte != null) {
			if((boolean) estConnecte){
				return inv.invoke();
			} else {
				return "login";
			}
		} else {
			return "login";
		}
	}

}
