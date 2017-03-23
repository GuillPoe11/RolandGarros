package presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Arbitre;
import entite.Court;
import entite.Equipe;
import entite.Joueur;
import entite.Match;
import entite.SousTournoi;
import metier.ArbitreService;
import metier.CourtService;
import metier.EquipeService;
import metier.JoueurService;
import metier.MatchService;
import metier.SousTournoiService;

public class PlanifierMatchAction extends ActionSupport {
	@SuppressWarnings("unused")
	@Autowired
	private MatchService service;
	@SuppressWarnings("unused")
	@Autowired
	private JoueurService joueurService;
	@SuppressWarnings("unused")
	@Autowired
	private EquipeService equipeService;
	@SuppressWarnings("unused")
	@Autowired
	private CourtService courtService;
	@SuppressWarnings("unused")
	@Autowired
	private SousTournoiService sousTournoiService;
	@SuppressWarnings("unused")
	@Autowired
	private ArbitreService arbitreService;
	private Map<Integer, String> mapJoueurs;
	private Map<Integer, String> mapEquipes;
	private Map<Integer, String> mapArbitres;
	private Map<Integer, String> mapSousTournois;
	private Map<Integer, String> mapCourts;
	private static final long serialVersionUID = 77971771589810L;

	private Match match;
	private List<Match> lstMatchs;

	public PlanifierMatchAction(@Autowired MatchService service, @Autowired JoueurService joueurService,
			@Autowired EquipeService equipeService, @Autowired CourtService courtService,
			@Autowired SousTournoiService sousTournoiService, @Autowired ArbitreService arbitreService) {
		super();
		lstMatchs = service.recupererTousLesMatchs();
		mapJoueurs = listToMap(new ArrayList<Object>(joueurService.recupererTousLesJoueurs()));
		mapEquipes = listToMap(new ArrayList<Object>(equipeService.recupererToutesLesEquipes()));
		mapArbitres = listToMap(new ArrayList<Object>(arbitreService.recupTousArbitres()));
		mapSousTournois = listToMap(new ArrayList<Object>(sousTournoiService.recupererTousLesSousTournois()));
		mapCourts = listToMap(new ArrayList<Object>(courtService.recupTousCourts()));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Fonction qui ajoute un latch lorsque l'organisateur clique sur le bouton
	 * refuse l'ajout si les conditions ne sont pas respectées
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

	public Map<Integer, String> getMapJoueurs() {
		return mapJoueurs;
	}

	public void setMapJoueurs(Map<Integer, String> mapJoueurs) {
		this.mapJoueurs = mapJoueurs;
	}


	public Map<Integer, String> getMapEquipes() {
		return mapEquipes;
	}

	public void setMapEquipes(Map<Integer, String> mapEquipes) {
		this.mapEquipes = mapEquipes;
	}

	public Map<Integer, String> getMapArbitres() {
		return mapArbitres;
	}

	public void setMapArbitres(Map<Integer, String> mapArbitres) {
		this.mapArbitres = mapArbitres;
	}

	public Map<Integer, String> getMapSousTournois() {
		return mapSousTournois;
	}

	public void setMapSousTournois(Map<Integer, String> mapSousTournois) {
		this.mapSousTournois = mapSousTournois;
	}

	public Map<Integer, String> getMapCourts() {
		return mapCourts;
	}

	public void setMapCourts(Map<Integer, String> mapCourts) {
		this.mapCourts = mapCourts;
	}


	/**
	 * Fonction de vérification si un arbitre existe déjà
	 * 
	 * @param nom
	 * @param prenom
	 * @return true or false
	 */
	public boolean verifArbitreExistants(String nom, String prenom) {
		// for (Arbitre arb : service.recupTousArbitres()) {
		// if (arb.getNomArbitre().equals(nom) &&
		// arb.getPrenomArbitre().equals(prenom)) {
		// return false;
		// }
		// }
		return true;
	}

	/**
	 * Permet de remplir une Map utilisée pour afficher le select sur la jsp à
	 * partir d'une liste d'object.
	 * 
	 * @param list
	 *            Une liste d'object
	 * @return La HashMap dont les valeurs sont des chaines de caractères
	 *         correspondant aux libellés des objects et les clés des entiers
	 *         correspondant à l'indice des objects dans la liste entrée en
	 *         paramètre.
	 * @author arnaud.poe11
	 */
	private Map<Integer, String> listToMap(List<Object> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i = 0;

		for (Object obj : list) {
			switch (obj.getClass().getName()) {
			case "entite.Joueur":
				map.put(i, ((Joueur) obj).getNomJoueur() + "-" + ((Joueur) obj).getPrenomJoueur());
				break;

			case "entite.Equipe":
				map.put(i,
						((Equipe) obj).getJoueur1().getNomJoueur() + "-" + ((Equipe) obj).getJoueur1().getNomJoueur());
				break;

			case "entite.SousTournoi":
				map.put(i, ((SousTournoi) obj).getNomSousTournoi());
				break;

			case "entite.Court":
				map.put(i, ((Court) obj).getNomCourt());
				break;

			case "entite.Arbitre":
				map.put(i, ((Arbitre) obj).getNomArbitre() + "-" + ((Arbitre) obj).getPrenomArbitre());
				break;

			default:

				/* Action */;

			}
			i++;
		}
		return map;
	}

}
