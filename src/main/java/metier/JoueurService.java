package metier;

import java.util.List;

import entite.Joueur;
import entite.Nationalite;

public interface JoueurService {
	
	
	/**
	 * Créer un joueur
	 * @param nomJoueur
	 * @param prenomJoueur
	 * @param sexeJoueur
	 * @param nationalite
	 */
	public void creerJoueur(String nomJoueur, String prenomJoueur, Character sexeJoueur, Nationalite nationalite);
	
	
	/**
	 * Récupère un joueur par l'id
	 * @param id
	 */
	public Joueur recupererJoueurParId(int id);

	
	/**
	 * Récupère la liste des joueurs
	 * @return La liste des joueurs
	 */
	public List<Joueur> recupererTousLesJoueurs();
}