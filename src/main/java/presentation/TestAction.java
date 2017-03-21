package presentation;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Nationalite;
import metier.JoueurService;
import metier.NationaliteService;
import metier.TestService;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = -8917369408257066341L;

	@Autowired
	private JoueurService jService;
	@Autowired
	private NationaliteService nService;

	private String nom;

	public TestAction() {
	}
	
	public String testG() {
		Nationalite n = nService.recupNationaliteParId(15);
		jService.creerJoueur("cretin", "lapin", 'M', n);;
		return "success";
	}
	
	

//	public String test() {
//		testService.setNom("test");
//		nom = testService.getNom();
//		return "success";
//	}
//	
//	public String ajout() {
//		testService.ajouterPersonne();
//		return "success";
//	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
