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
	private Integer idEquipe1;
	private Integer idEquipe2;
	private Integer idJoueur1;
	private Integer idJoueur2;
	private Integer idSousTournoi;
	private Integer idArbitre;
	private Integer idCourt;

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
	 * Fonction qui ajoute un match lorsque l'organisateur clique sur le bouton
	 * refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * return string vers la page match
	 */
	public String creerMatch() {
		System.out.println(match);
		if (verifMatchs()) {
			match.setArbitre(arbitreService.recupArbitreParId(idArbitre));
			match.setCourt(courtService.recupCourtParId(idCourt));
			match.setEquipe1(equipeService.recupererEquipe(idEquipe1));
			match.setEquipe2(equipeService.recupererEquipe(idEquipe2));
			match.setJoueur1(joueurService.recupererJoueurParId(idJoueur1));
			match.setJoueur2(joueurService.recupererJoueurParId(idJoueur2));
			for (SousTournoi s : sousTournoiService.recupererTousLesSousTournois()) {
				if (s.getIdSousTournoi() == idSousTournoi) {
					match.setSousTournoi(s);
				}
			}
			System.out.println(match);
			service.creerMatch(match.getCourt(), match.getJoueur1(), match.getJoueur2(), match.getArbitre(),
					match.getSousTournoi(), match.getDateMatch(), match.getEquipe1(), match.getEquipe2());
			lstMatchs = service.recupererTousLesMatchs();
		}
		System.out.println(match);
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

	public Integer getIdEquipe1() {
		return idEquipe1;
	}

	public void setIdEquipe1(Integer idEquipe1) {
		this.idEquipe1 = idEquipe1;
	}

	public Integer getIdEquipe2() {
		return idEquipe2;
	}

	public void setIdEquipe2(Integer idEquipe2) {
		this.idEquipe2 = idEquipe2;
	}

	public Integer getIdJoueur1() {
		return idJoueur1;
	}

	public void setIdJoueur1(Integer idJoueur1) {
		this.idJoueur1 = idJoueur1;
	}

	public Integer getIdJoueur2() {
		return idJoueur2;
	}

	public void setIdJoueur2(Integer idJoueur2) {
		this.idJoueur2 = idJoueur2;
	}

	public Integer getIdSousTournoi() {
		return idSousTournoi;
	}

	public void setIdSousTournoi(Integer idSousTournoi) {
		this.idSousTournoi = idSousTournoi;
	}

	public Integer getIdArbitre() {
		return idArbitre;
	}

	public void setIdArbitre(Integer idArbitre) {
		this.idArbitre = idArbitre;
	}

	public Integer getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(Integer idCourt) {
		this.idCourt = idCourt;
	}

	/**
	 * Fonction de vérification si un match peut être ajouté
	 * 
	 * @return true or false
	 */
	public boolean verifMatchs() {

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

		for (Object obj : list) {
			switch (obj.getClass().getName()) {
			case "entite.Joueur":
				map.put(((Joueur) obj).getIdJoueur(),
						((Joueur) obj).getNomJoueur() + "-" + ((Joueur) obj).getPrenomJoueur());
				break;

			case "entite.Equipe":
				map.put(((Equipe) obj).getIdEquipe(),
						((Equipe) obj).getJoueur1().getNomJoueur() + "-" + ((Equipe) obj).getJoueur2().getNomJoueur());
				break;

			case "entite.SousTournoi":
				map.put(((SousTournoi) obj).getIdSousTournoi(), ((SousTournoi) obj).getNomSousTournoi());
				break;

			case "entite.Court":
				map.put(((Court) obj).getIdCourt(), ((Court) obj).getNomCourt());
				break;

			case "entite.Arbitre":
				map.put(((Arbitre) obj).getIdArbitre(),
						((Arbitre) obj).getNomArbitre() + "-" + ((Arbitre) obj).getPrenomArbitre());
				break;

			default:

				/* Action */;

			}
		}
		return map;
	}

}
