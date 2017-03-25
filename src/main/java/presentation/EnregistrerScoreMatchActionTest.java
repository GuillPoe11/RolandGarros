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
	private MatchService service;

	private static final long serialVersionUID = 77971771589810L;

	private Match match;

	private List<Match> lstMatchs;

	private Integer idMatchDansLst;

	private Map<Integer, String> mapMatchs;

	public EnregistrerScoreMatchActionTest(@Autowired MatchService service) {
		lstMatchs = service.recupererTousLesMatchs();
		Utilitaire util = new Utilitaire();
		mapMatchs = util.listToMap(new ArrayList<Object>(lstMatchs));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String recupMatch() {
		for (int i = 0; i < lstMatchs.size(); i++) {
			if (i == idMatchDansLst) {
				match = lstMatchs.get(i);
			}
		}
		return "success";
	}

	/**
	 * Fonction qui ajoute un match lorsque l'organisateur clique sur le bouton
	 * refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * @return string vers la page match
	 */
	public String modifierMatch() {

		if (verifMatchs()) {
			System.out.println(match);
			recupMatch();
			System.out.println(match);
			service.modifierMatch(match, match.getDateMatch(), match.getDureeMatch(), match.getScore1(),
					match.getScore2());
		}

		return "success";
	}

	/*
	 * Getters/Setters
	 */

	public List<Match> getLstArbitres() {
		return lstMatchs;
	}

	public Map<Integer, String> getMapMatchs() {
		return mapMatchs;
	}

	public void setMapMatchs(Map<Integer, String> mapMatchs) {
		this.mapMatchs = mapMatchs;
	}

	public void setLstArbitres(List<Match> lstArbitres) {
		this.lstMatchs = lstArbitres;
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

	/**
	 * Fonction de vérification si un match peut être ajouté
	 * 
	 * @return true or false
	 */
	public boolean verifMatchs() {
		// TODO
		return true;
	}
}
