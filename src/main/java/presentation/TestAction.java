package presentation;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import metier.TestService;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = -8917369408257066341L;

	@Autowired
	private TestService testService;

	private String nom;

	public TestAction() {
	}

	public String test() {
		testService.setNom("test");
		nom = testService.getNom();
		return "success";
	}
	
	public String ajout() {
		testService.ajouterPersonne();
		return "success";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
