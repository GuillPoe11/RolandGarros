package metier;

import org.springframework.stereotype.Component;

@Component
public class TestService {
	
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

}
