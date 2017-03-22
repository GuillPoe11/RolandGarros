package presentation;

import com.opensymphony.xwork2.ActionSupport;

import metier.ArbitreService;

public class AjouterArbitre  extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	
	public AjouterArbitre() {
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
