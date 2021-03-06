package presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Match;
import metier.interfaces.MatchService;

/**
 * Action qui gére la modification d'un match : pour l'enregistrement du score1,
 * score2 et durée
 * 
 * @author Guillaume
 *
 */
public class EnregistrerScoreMatchAction extends ActionSupport {

	@Autowired
	private MatchService matchService;

	private static final long serialVersionUID = 77971771589810L;

	private Match match;

	private List<Match> lstMatchs;

	// Variables du formulaire
	private Integer idMatchDansSelect;
	private Integer score1;
	private Integer score2;
	private Integer duree;

	private List<Integer> lstHeures;

	private Integer integerHeure;
	private Integer integerMinute;
	private String dateMatch;

	// Variables msg d'erreur
	private String msgForm;
	private String typeMsgForm;

	// map des match pour construire le select
	private Map<Integer, String> mapMatchs;

	/**
	 * Constructeur
	 * 
	 * @param matchService
	 */
	public EnregistrerScoreMatchAction(@Autowired MatchService matchService) {
		lstMatchs = matchService.recupererTousLesMatchsAModifier();

		Utilitaire util = new Utilitaire();
		mapMatchs = util.listToMap(new ArrayList<Object>(lstMatchs));

		// remplir liste des heures pour le select
		lstHeures = new ArrayList<Integer>();
		for (int i = 0; i < 24; i++) {
			lstHeures.add(i);
		}
	}

	public Match recupMatch(int idMatchDansSelect) {

		for (int i = 0; i < lstMatchs.size(); i++) {
			

			if (lstMatchs.get(i).getIdMatch() == idMatchDansSelect) {
				match = lstMatchs.get(i);
				
			}
		}

		return match;

	}

	/**
	 * Fonction qui ajoute un match lorsque l'organisateur clique sur le bouton
	 * refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * @return string vers la page match
	 */
	public String modifierMatch() {

		if (!(score1 instanceof Integer)) {
			msgForm = "Le score joueur1 doit être un nombre";
			typeMsgForm = "alert alert-danger";
			
			return "input";
			// TODO
			// ########### le controle d'erreur marche pas bordel !
		}
		

		else {
			
			match = recupMatch(idMatchDansSelect);

			
			// Recup date dans le formulaire
			// on vérifie que les champs date ne sont pas vides
			if (!"".equals(dateMatch) && integerHeure != null && integerMinute != null) {

				Date dateMatchFormat = new Date();
				String strDateHeureMatch = dateMatch + " " + integerHeure + ":" + integerMinute;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
				// on vérifie que le format de date et bon
				try {

					dateMatchFormat = sdf.parse(strDateHeureMatch);

					// tout est bon
					// on enregistre
					// date initiale : match.getDateMatch();
					
					matchService.modifierMatch(match, dateMatchFormat, duree, score1, score2);

					msgForm = "Score enregistré";
					typeMsgForm = "alert alert-success";

				} catch (ParseException e) {

					msgForm = "Attention la date n'a pas le bon format\r\n";
					typeMsgForm = "alert alert-danger";
				}
			} else {
				// la date est vide
				// on enregistre

				matchService.modifierMatch(match, match.getDateMatch(), duree, score1, score2);

				msgForm = "Score enregistré";
				typeMsgForm = "alert alert-success";
			}
			lstMatchs = matchService.recupererTousLesMatchsAModifier();
			return "success";
		}

	}

	/*
	 * Getters/Setters
	 */

	public String getMsgForm() {
		return msgForm;
	}

	public void setMsgForm(String msgForm) {
		this.msgForm = msgForm;
	}

	public String getTypeMsgForm() {
		return typeMsgForm;
	}

	public void setTypeMsgForm(String typeMsgForm) {
		this.typeMsgForm = typeMsgForm;
	}

	public Integer getIntegerHeure() {
		return integerHeure;
	}

	public void setIntegerHeure(Integer integerHeure) {
		this.integerHeure = integerHeure;
	}

	public Integer getIntegerMinute() {
		return integerMinute;
	}

	public void setIntegerMinute(Integer integerMinute) {
		this.integerMinute = integerMinute;
	}

	public String getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(String dateMatch) {
		this.dateMatch = dateMatch;
	}

	public List<Integer> getLstHeures() {
		return lstHeures;
	}

	public void setLstHeures(List<Integer> lstHeures) {
		this.lstHeures = lstHeures;
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

	public Integer getIdMatchDansSelect() {
		return idMatchDansSelect;
	}

	public void setIdMatchDansSelect(Integer idMatchDansSelect) {
		this.idMatchDansSelect = idMatchDansSelect;
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
