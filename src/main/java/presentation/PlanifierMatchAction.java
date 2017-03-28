package presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import metier.exception.MatchException;
import metier.interfaces.ArbitreService;
import metier.interfaces.CourtService;
import metier.interfaces.EquipeService;
import metier.interfaces.JoueurService;
import metier.interfaces.MatchService;
import metier.interfaces.SousTournoiService;

public class PlanifierMatchAction extends ActionSupport {

	@Autowired
	private MatchService service;

	@Autowired
	private JoueurService joueurService;

	@Autowired
	private EquipeService equipeService;

	@Autowired
	private CourtService courtService;

	@Autowired
	private SousTournoiService sousTournoiService;

	@Autowired
	private ArbitreService arbitreService;

	private Map<Integer, String> mapJoueurs;
	private Map<Integer, String> mapEquipes;
	private Map<Integer, String> mapArbitres;
	private Map<Integer, String> mapSousTournoisSimple;
	private Map<Integer, String> mapSousTournoisEquipe;
	private Map<Integer, String> mapCourts;

	private static final long serialVersionUID = 77971771589810L;

	private Match match;

	private List<Match> lstMatchs;
	private List<Match> lstDixDerniersMatchsSimple;
	private List<Match> lstDixDerniersMatchsEquipe;

	private Integer idEquipe1;
	private Integer idEquipe2;
	private Integer idJoueur1;
	private Integer idJoueur2;
	private Integer idSousTournoi;
	private Integer idArbitre;
	private Integer idCourt;

	private List<Integer> lstHeures;

	// pour recup champ formulaire
	private Integer integerHeure;
	private Integer integerMinute;
	private String dateMatch;

	// pour l'affichage des message d'erreur
	private String msgForm;
	private String typeMsgForm;

	/**
	 * Constructeur
	 */
	public PlanifierMatchAction(@Autowired MatchService service, @Autowired JoueurService joueurService,
			@Autowired EquipeService equipeService, @Autowired CourtService courtService,
			@Autowired SousTournoiService sousTournoiService, @Autowired ArbitreService arbitreService) {

		// remplir liste des heures pour le select
		lstHeures = new ArrayList<Integer>();
		for (int i = 0; i < 24; i++) {
			lstHeures.add(i);
		}

		// lstMatchs = service.recupererTousLesMatchs();
		lstDixDerniersMatchsSimple = service.recupererLesDixDerniersMatchsSimples();
		lstDixDerniersMatchsEquipe = service.recupererLesDixDerniersMatchsEnEquipe();

		mapJoueurs = listToMap(new ArrayList<Object>(joueurService.recupererTousLesJoueurs()));
		mapEquipes = listToMap(new ArrayList<Object>(equipeService.recupererToutesLesEquipes()));
		mapArbitres = listToMap(new ArrayList<Object>(arbitreService.recupTousArbitres()));
		mapSousTournoisEquipe = listToMap(
				new ArrayList<Object>(sousTournoiService.recupererTousLesSousTournoisEquipe()));
		mapSousTournoisSimple = listToMap(
				new ArrayList<Object>(sousTournoiService.recupererTousLesSousTournoisSimple()));
		mapCourts = listToMap(new ArrayList<Object>(courtService.recupTousCourts()));
	}

	/**
	 * Renvoie vers la page de planification de match simple
	 * 
	 * @return string vers la page match
	 */
	public String choixMatchSimple() {
		return "simple";
	}

	/**
	 * Renvoie vers la page de planification de match équipe
	 * 
	 * @return string vers la page match
	 */
	public String choixMatchEquipe() {
		return "equipe";
	}

	/**
	 * Fonction qui ajoute un match simple lorsque l'organisateur clique sur le
	 * bouton refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * @return string vers la page match
	 */
	public String creerMatchSimple() {

		Date dateMatchFormat = new Date();

		String strDateHeureMatch = dateMatch + " " + integerHeure + ":" + integerMinute;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
		try {
			dateMatchFormat = sdf.parse(strDateHeureMatch);
		} catch (ParseException e) {
			msgForm = "Attention la date n'a pas le bon format\r\n";
			typeMsgForm = "alert alert-danger";
		}

		if (verifMatchSimple()) {
			try {
				service.creerMatch(courtService.recupCourtParId(idCourt), joueurService.recupererJoueurParId(idJoueur1),
						joueurService.recupererJoueurParId(idJoueur2), arbitreService.recupArbitreParId(idArbitre),
						sousTournoiService.recupererSousTournoiParId(idSousTournoi), dateMatchFormat, null, null);
				lstDixDerniersMatchsSimple = service.recupererLesDixDerniersMatchsSimples();
			} catch (MatchException e) {
				msgForm = e.getMessage();
				typeMsgForm = "alert alert-danger";
			}

		}
		return "simple";
	}

	/**
	 * Fonction qui ajoute un match simple lorsque l'organisateur clique sur le
	 * bouton refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * @return string vers la page match
	 */
	public String creerMatchEquipe() {

		Date dateMatchFormat = new Date();

		String strDateHeureMatch = dateMatch + " " + integerHeure + ":" + integerMinute;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
		try {
			dateMatchFormat = sdf.parse(strDateHeureMatch);
		} catch (ParseException e) {
			msgForm = "Attention la date n'a pas le bon format\r\n";
			typeMsgForm = "alert alert-danger";
		}

		if (verifMatchEquipe()) {
			try {
				service.creerMatch(courtService.recupCourtParId(idCourt), null, null,
						arbitreService.recupArbitreParId(idArbitre),
						sousTournoiService.recupererSousTournoiParId(idSousTournoi), dateMatchFormat,
						equipeService.recupererEquipeParId(idEquipe1), equipeService.recupererEquipeParId(idEquipe2));
				lstDixDerniersMatchsEquipe = service.recupererLesDixDerniersMatchsEnEquipe();
			} catch (MatchException e) {
				msgForm = e.getMessage();
				typeMsgForm = "alert alert-danger";
			}

		}
		return "equipe";
	}

	// /**
	// * Fonction qui ajoute un match lorsque l'organisateur clique sur le
	// bouton
	// * refuse l'ajout si les conditions ne sont pas respectées
	// *
	// * @return string vers la page match
	// */
	// public String creerMatch() {
	//
	// Date dateMatchFormat = new Date();
	//
	// String strDateHeureMatch = dateMatch + " " + integerHeure + ":" +
	// integerMinute;
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
	// try {
	// dateMatchFormat = sdf.parse(strDateHeureMatch);
	// } catch (ParseException e) {
	// msgForm = "Attention la date n'a pas le bon format\r\n";
	// typeMsgForm = "alert alert-danger";
	// }
	//
	// if (verifMatchEquipe()) {
	// try {
	// service.creerMatch(courtService.recupCourtParId(idCourt),
	// joueurService.recupererJoueurParId(idJoueur1),
	// joueurService.recupererJoueurParId(idJoueur2),
	// arbitreService.recupArbitreParId(idArbitre),
	// sousTournoiService.recupererSousTournoiParId(idSousTournoi),
	// dateMatchFormat,
	// equipeService.recupererEquipeParId(idEquipe1),
	// equipeService.recupererEquipeParId(idEquipe2));
	//
	// } catch (MatchException e) {
	// msgForm = e.getMessage();
	// typeMsgForm = "alert alert-danger";
	// }
	//
	// }
	// return "success";
	// }

	/**
	 * Fonction de vérification si un match en simple peut être ajouté. Controle
	 * arbitre, soustournoi et court choisi
	 * 
	 * @return true or false
	 */
	public boolean verifMatchSimple() {
		if (idCourt == -1) {
			msgForm = "Vous n'avez pas choisi le court";
			typeMsgForm = "alert alert-danger";
			return false;
		} else if (idSousTournoi == -1) {
			msgForm = "Vous n'avez pas choisi le sous-tournoi";
			typeMsgForm = "alert alert-danger";
			return false;
		} else if (idArbitre == -1) {
			msgForm = "Vous n'avez pas choisi l'arbitre";
			typeMsgForm = "alert alert-danger";
			return false;
		} else {
			msgForm = "Le match a été créé";
			typeMsgForm = "alert alert-success";
			return true;
		}

	}

	/**
	 * Fonction de vérification si un match en équipe peut être ajouté. Controle
	 * arbitre, soustournoi et court choisi
	 * 
	 * @return true or false
	 */
	public boolean verifMatchEquipe() {
		if (idCourt == -1) {
			msgForm = "Vous n'avez pas choisi le court";
			typeMsgForm = "alert alert-danger";
			return false;
		} else if (idSousTournoi == -1) {
			msgForm = "Vous n'avez pas choisi le sous-tournoi";
			typeMsgForm = "alert alert-danger";
			return false;
		} else if (idArbitre == -1) {
			msgForm = "Vous n'avez pas choisi l'arbitre";
			typeMsgForm = "alert alert-danger";
			return false;
		} else if ((idEquipe1 == idEquipe2) && (idEquipe1 > 0)) {
			msgForm = "La même equipe ne peut-etre sélectionnée deux fois";
			typeMsgForm = "alert alert-danger";
			return false;
		} else {
			msgForm = "Le match a été créé";
			typeMsgForm = "alert alert-success";
			return true;
		}

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
	 */
	private Map<Integer, String> listToMap(List<Object> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		for (Object obj : list) {
			switch (obj.getClass().getName()) {
			case "entite.Joueur":
				map.put(((Joueur) obj).getIdJoueur(),
						((Joueur) obj).getPrenomJoueur() + " " + ((Joueur) obj).getNomJoueur());
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
						((Arbitre) obj).getPrenomArbitre() + " " + ((Arbitre) obj).getNomArbitre());
				break;

			default:

				/* Action */;
				break;
			}
		}
		return map;
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

	public String getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(String dateMatch) {
		this.dateMatch = dateMatch;
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

	public List<Integer> getLstHeures() {
		return lstHeures;
	}

	public void setLstHeures(List<Integer> lstHeures) {
		this.lstHeures = lstHeures;
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

	public Map<Integer, String> getMapSousTournoisSimple() {
		return mapSousTournoisSimple;
	}

	public void setMapSousTournoisSimple(Map<Integer, String> mapSousTournoisSimple) {
		this.mapSousTournoisSimple = mapSousTournoisSimple;
	}

	public Map<Integer, String> getMapSousTournoisEquipe() {
		return mapSousTournoisEquipe;
	}

	public void setMapSousTournoisEquipe(Map<Integer, String> mapSousTournoisEquipe) {
		this.mapSousTournoisEquipe = mapSousTournoisEquipe;
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

	public List<Match> getLstDixDerniersMatchsSimple() {
		return lstDixDerniersMatchsSimple;
	}

	public void setLstDixDerniersMatchsSimple(List<Match> lstDixDerniersMatchsSimple) {
		this.lstDixDerniersMatchsSimple = lstDixDerniersMatchsSimple;
	}

	public List<Match> getLstDixDerniersMatchsEquipe() {
		return lstDixDerniersMatchsEquipe;
	}

	public void setLstDixDerniersMatchsEquipe(List<Match> lstDixDerniersMatchsEquipe) {
		this.lstDixDerniersMatchsEquipe = lstDixDerniersMatchsEquipe;
	}

	// fin getters setters
}
