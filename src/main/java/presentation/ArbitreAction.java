package presentation;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import metier.ArbitreService;

public class ArbitreAction extends ActionSupport {

	@Autowired
	ArbitreService service;
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;

	public ArbitreAction() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String submit() {
		if (nom != null && !"".equals(nom) && prenom != null && !"".equals(prenom) && nom.length() > 3
				&& prenom.length() > 3) {
			service.insererArbitre(nom, prenom);
		}
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
