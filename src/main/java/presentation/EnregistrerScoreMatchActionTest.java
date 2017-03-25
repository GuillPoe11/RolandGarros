package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Match;
import metier.MatchService;

public class EnregistrerScoreMatchActionTest extends ActionSupport {

	@Autowired
	private MatchService matchService;

	private static final long serialVersionUID = 77971771589810L;

	private Match match;

	private List<Match> lstMatchs;

	private Integer idMatchDansLst;
	private Integer score1;
	private Integer score2;
	private Integer duree;

	private Map<Integer, String> mapMatchs;

	public EnregistrerScoreMatchActionTest(@Autowired MatchService matchService) {
		lstMatchs = matchService.recupererTousLesMatchs();
		Utilitaire util = new Utilitaire();
		mapMatchs = util.listToMap(new ArrayList<Object>(lstMatchs));
	}

	public Match recupMatch(int idMatchDansLst) {

		Match match = lstMatchs.get(idMatchDansLst);
		return match;

	}

	/**
	 * Fonction qui ajoute un match lorsque l'organisateur clique sur le bouton
	 * refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * @return string vers la page match
	 */
	public String modifierMatch() {
		System.out.println("--------------" + idMatchDansLst);
		System.out.println(match);

		// if (verifMatchs()) {
		// System.out.println(match);
		match = recupMatch(idMatchDansLst);
		System.out.println(match);

		
		matchService.modifierMatch(match, match.getDateMatch(), duree,score1,
				score2);
		// }

		return "success";
	}

	/*
	 * Getters/Setters
	 */

	/**
	 * Fonction de vérification si un match peut être modifié
	 * 
	 * @return true or false
	 */
	public boolean verifMatchs() {
		// TODO
		return true;
	}

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<Match> getLstMatchs() {
		return lstMatchs;
	}

	public void setLstMatchs(List<Match> lstMatchs) {
		this.lstMatchs = lstMatchs;
	}

	public Integer getIdMatchDansLst() {
		return idMatchDansLst;
	}

	public void setIdMatchDansLst(Integer idMatchDansLst) {
		this.idMatchDansLst = idMatchDansLst;
	}

	public Integer getScore1() {
		return score1;
	}

	public void setScore1(Integer score1) {
		this.score1 = score1;
	}

	public Integer getScore2() {
		return score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Map<Integer, String> getMapMatchs() {
		return mapMatchs;
	}

	public void setMapMatchs(Map<Integer, String> mapMatchs) {
		this.mapMatchs = mapMatchs;
	}
}
