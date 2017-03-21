package dao;

import java.util.List;

import entite.Match;
import entite.SousTournoi;

public interface MatchDao {

	/**
	 * ajoute un match
	 * 
	 * @param m
	 *            : match
	 */
	public void insererMatch(Match m);

	/**
	 * efface un match
	 * 
	 * @param m
	 *            : match
	 */
	public void effacer(Match m);

	/**
	 * modifie un match
	 * 
	 * @param m
	 *            : match
	 */
	public void modifier(Match m);

	/**
	 * Retourne le contenu de la tableBdd match
	 * @return une liste de match
	 */
	public List<Match> recupTousMatchs();
	
	
	/**
	 * Retourne le contenu de la tableBdd pour un tournoi
	 * @return une liste de match
	 */
	public List<Match> recupTousMatchsPourUnSousTournoi(SousTournoi sousTournoi);

	/**
	 * Retourne un match selectionne par son id
	 * 
	 * @param id
	 *            : id match recherche
	 * @return match
	 */
	public Match recupMatchParId(int id);

}
