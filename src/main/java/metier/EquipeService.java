package metier;

import java.util.List;

import entite.Equipe;
import entite.Joueur;
import metier.exception.EquipeException;

public interface EquipeService {

	/**
	 * Crée une équipe avec deux joueurs passés en paramètres
	 * @param joueur1 Le premier Joueur
	 * @param joueur2 Le deuxième Joueur
	 */
	public void creerEquipe(Joueur joueur1, Joueur joueur2) throws EquipeException;
	
	/**
	 * Renvoie une équipe grâce à son identifiant
	 * @return L'équipe désirée
	 */
	public Equipe recupererEquipeParId(Integer idEquipe);
	
	/**
	 * Récupère la liste des équipes
	 * @return La liste des équipes
	 */
	public List<Equipe> recupererToutesLesEquipes();
	
	/**
	 * Récupère la liste des 10 dernières équipes enregistrées en BDD
	 * @return La liste des 10 dernières équipes
	 */
	public List<Equipe> recupererLesDixDernieresEquipes();
	
}
