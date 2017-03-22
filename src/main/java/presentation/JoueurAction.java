package presentation;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Joueur;
import metier.JoueurService;

public class JoueurAction extends ActionSupport {

	private static final long serialVersionUID = -2439182379487460604L;

	@Autowired
	private JoueurService joueurService;

	private Joueur joueur;

	public JoueurAction() {
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
