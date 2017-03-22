package presentation;

import com.opensymphony.xwork2.ActionSupport;

import metier.LoginService;

public class AccueilAction  extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public AccueilAction() {
		super();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String AccueilAction() {
		return "success";
	}

	
	

}
