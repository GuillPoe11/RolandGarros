package presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Match;
import metier.MatchService;
import metier.exception.MatchException;

public class EnregistrerScoreMatchAction extends ActionSupport {

	@Autowired
	private MatchService service;

	private static final long serialVersionUID = 77971771589810L;

	private Match match;

	private List<Match> lstMatchs;

	private Integer idMatchDansLst;

	public EnregistrerScoreMatchAction(@Autowired MatchService service) {
		lstMatchs = service.recupererTousLesMatchs();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String recupMatch() {

		System.out.println("HERRE" + idMatchDansLst);
		for (Match temp : lstMatchs) {
			if (temp.getIdMatch() == idMatchDansLst) {
				match.setIdMatch(idMatchDansLst);
				match.setArbitre(temp.getArbitre());
				match.setCourt(temp.getCourt());
				match.setEquipe1(temp.getEquipe1());
				match.setEquipe2(temp.getEquipe2());
				match.setJoueur1(temp.getJoueur1());
				match.setJoueur2(temp.getJoueur2());
				match.setSousTournoi(temp.getSousTournoi());
				match.setDateMatch(match.getDateMatch());
				match.setDureeMatch(temp.getDureeMatch());
				match.setScore1(temp.getScore1());
				match.setScore2(temp.getScore2());
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

			match.setDateMatch(match.getDateMatch());

			System.out.println(match);

			try {
				service.creerMatch(match.getCourt(), match.getJoueur1(), match.getJoueur2(), match.getArbitre(),
						match.getSousTournoi(), match.getDateMatch(), match.getEquipe1(), match.getEquipe2());
			} catch (MatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// lstMatchs = service.recupererTousLesMatchs();
		}

		return "success";
	}

	/*
	 * Getters/Setters
	 */

	public List<Match> getLstArbitres() {
		return lstMatchs;
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
