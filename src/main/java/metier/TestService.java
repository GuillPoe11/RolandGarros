package metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.JoueurDao;
import entite.Joueur;
import entite.Nationalite;

@Component
public class TestService {

//	@Autowired
//	private PersonneDAO dao;

	@Autowired
	private JoueurDao jDao;
	
	@Autowired
	private Nationalite nDao;

	private String nom;

	/*
	 * Constructeurs
	 */
	public TestService() {

	}
	
	/*
	 * Getters / Setters
	 */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

//	public void ajouterPersonne() {
//		Personne p = new Personne();
//		p.setCountry("France");
//		p.setName("toto");
//		dao.sauvegarderPersonne(p);
//	}
	
	public void testGuill() {
		// creation de Joueurs
		System.out.println("creation de nationalite");
		Nationalite n1 = nDao.recupNationaliteParId(1);
//		Nationalite n2 = jDao.getNationalite(2);

		// creation de Joueurs
		System.out.println("creation de joueurs");
		Joueur j1 = new Joueur("lapin", "cretin", 'M', n1);
//		Joueur j2 = jDao.getJoueur("mario", "super", 'M', n1);
//		Joueur j3 = jDao.getJoueur("moon", "Sailor", 'F', n1);
		
		jDao.insererJoueur(j1);

	}
	
	

}
