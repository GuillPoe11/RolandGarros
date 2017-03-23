package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Match;
import metier.MatchService;

public class PlanifierMatchAction extends ActionSupport {
	@Autowired
	private MatchService service;
	private static final long serialVersionUID = 77971771589810L;

	private Match match;
	private List<Match> lstMatchs;

	public PlanifierMatchAction(@Autowired MatchService service) {
		super();
		lstMatchs = service.recupererTousLesMatchs();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Fonction qui ajoute un latch lorsque l'organisateur clique sur le
	 * bouton refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * return string vers la page match
	 */
	public String submite() {
		
		return "success";
	}

	public Match getArbitre() {
		return match;
	}

	public void setArbitre(Match match) {
		this.match = match;
	}

	public List<Match> getLstArbitres() {
		return lstMatchs;
	}

	public void setLstArbitres(List<Match> lstArbitres) {
		this.lstMatchs = lstArbitres;
	}


	/**
	 * Fonction de vérification si un arbitre existe déjà
	 * 
	 * @param nom
	 * @param prenom
	 * @return true or false
	 */
	public boolean verifArbitreExistants(String nom, String prenom) {
//		for (Arbitre arb : service.recupTousArbitres()) {
//			if (arb.getNomArbitre().equals(nom) && arb.getPrenomArbitre().equals(prenom)) {
//				return false;
//			}
//		}
		return true;
	}

}
