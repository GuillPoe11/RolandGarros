package metier;

import java.util.Date;
import java.util.List;

import entite.Arbitre;
import entite.Court;
import entite.Equipe;
import entite.Joueur;
import entite.Match;
import entite.SousTournoi;

public interface MatchService {

	/**
	 * Creer un match
	 * 
	 * @param court
	 *            : le Court concerné
	 * @param joueur1
	 *            : le premier Joueur de l'équipe concerné
	 * @param joueur2
	 *            : le deuxième Joueur de l'équipe concerné
	 * @param arbitre
	 *            : l'AjouterArbitre utilisé
	 * @param sousTournoi
	 *            :le SousTournoi concerné
	 * @param dateMatch
	 *            : la date du match
	 */
	public void creerMatch(Court court, Joueur joueur1, Joueur joueur2, Arbitre arbitre, SousTournoi sousTournoi,
			Date dateMatch, Equipe equipe1, Equipe equipe2);

	/**
	 * Modifier un match
	 * 
	 * @param match
	 *            : le match à modifier
	 * @param dateMatch
	 *            : la date du match
	 * @param dureeMatch
	 *            : la durée du match en minutes
	 * @param score1Match
	 *            : le score du joueur / equipe 1
	 * @param score2Match
	 *            : le score du joueur / equipe 2
	 * 
	 */
	public void modifierMatch(Match match, Date dateMatch, Integer dureeMatch, Integer score1Match,
			Integer score2Match);

	/**
	 * Récupérer la liste de tous les matchs
	 * 
	 * @return liste de matchs
	 */
	public List<Match> recupererTousLesMatchs();
	
	
	/**
	 * Récupérer la liste de tous les matchs pour un soustournoi
	 * 
	 * @return liste de matchs
	 */
	public List<Match> recupererTousLesMatchsPourUnSousTournoi(SousTournoi sousTournoi);

}
