package presentation;

import com.opensymphony.xwork2.ActionSupport;

import metier.LoginService;

public class Accueil  extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public Accueil() {
		super();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String AccueilAction() {
		return "success";
	}

	
	

}
