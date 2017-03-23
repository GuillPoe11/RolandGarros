package presentation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Court;
import entite.Equipe;
import entite.Joueur;
import entite.Match;
import entite.SousTournoi;
import metier.MatchService;

public class ResultatAction extends ActionSupport {

	private static final long serialVersionUID = 59516144714998096L;

	@Autowired
	private MatchService matchService;

	private Match match;
	private Court court;
	private Joueur joueur1;
	private Joueur joueur2;
	private SousTournoi sousTournoi;
	private Date date;
	private int duree;
	private Equipe equipe1;
	private Equipe equipe2;
	private int score1;
	private int score2;

	private List<Match> lstMatchs;
	private Map<Integer, String> mapMatch;

	/*
	 * Constructeur
	 */
	public ResultatAction(@Autowired MatchService matchService) {
		lstMatchs = matchService.recupererTousLesMatchs();
		mapMatch = listToMap(matchService.recupererTousLesMatchs());
	}

	/**
	 * Permet de remplir une Map utilisée pour afficher le select sur la jsp à
	 * partir d'une liste de matchs.
	 * 
	 * @param list
	 *            Une liste de Matchs
	 * @return La HashMap dont les valeurs sont des chaines de caractères
	 *         correspondant aux courts, équipes, joueurs, scores, dates, durées
	 *         et les clés des entiers correspondant à l'indice des matchs dans
	 *         la liste entrée en paramètre.
	 */
	private Map<Integer, String> listToMap(List<Match> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i = 0;
		for (Match match : list) {
			map.put(i, match.getCourt() + " " + match.getDateMatch()+ " " + match.getSousTournoi()+ " " + match.getJoueur1()
			+ " " + match.getJoueur2()+ " " + match.getEquipe1()+ " " + match.getEquipe2()+ " " + match.getScore1()
			+ " " + match.getScore2()+ " " + match.getDureeMatch());
			i++;
		}
		return map;
	}

	/*
	 * Getters/Setters
	 */

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public SousTournoi getSousTournoi() {
		return sousTournoi;
	}

	public void setSousTournoi(SousTournoi sousTournoi) {
		this.sousTournoi = sousTournoi;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public List<Match> getLstMatchs() {
		return lstMatchs;
	}

	public void setLstMatchs(List<Match> lstMatchs) {
		this.lstMatchs = lstMatchs;
	}

	public Map<Integer, String> getMapMatch() {
		return mapMatch;
	}

	public void setMapMatch(Map<Integer, String> mapMatch) {
		this.mapMatch = mapMatch;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
