package metier;

import java.util.List;

import entite.Equipe;
import entite.Joueur;

public interface EquipeService {

	/**
	 * Crée une équipe avec deux joueurs passés en paramètres
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le deuxième joueur
	 */
	public void creerEquipe(Joueur joueur1, Joueur joueur2);
	
	public Equipe recupererEquipe();
	
	/**
	 * Récupère la liste des équipes
	 * @return La liste des équipes
	 */
	public List<Equipe> recupererToutesLesEquipes();
	
}
