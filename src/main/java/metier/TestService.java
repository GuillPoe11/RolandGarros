package metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.PersonneDAO;
import entite.Personne;

@Component
public class TestService {
	
	@Autowired
	private PersonneDAO dao;
	
	private String nom;

	public TestService() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void ajouterPersonne(){
		Personne p = new Personne();
		p.setCountry("France");
		p.setName("toto");
		dao.sauvegarderPersonne(p);
	}

}
