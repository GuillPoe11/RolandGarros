package presentation;

import com.opensymphony.xwork2.ActionSupport;

import metier.ArbitreService;

public class ArbitreAction  extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	
	public ArbitreAction() {
		super();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String AjoutArbitre() {
		return "success";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
