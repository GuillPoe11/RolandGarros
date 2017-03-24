package presentation;

import java.util.Date;
import java.util.List;

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
	private Date dateMatch;
	private int duree;
	private Equipe equipe1;
	private Equipe equipe2;
	private int score1;
	private int score2;

	private List<Match> lstMatchs;

	/*
	 * Constructeur
	 */
	public ResultatAction(@Autowired MatchService matchService) {
		lstMatchs = matchService.recupererTousLesMatchs();
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

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDate(Date dateMatch) {
		this.dateMatch = dateMatch;
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

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
