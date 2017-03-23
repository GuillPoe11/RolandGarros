package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Joueur;
import entite.Match;
import metier.JoueurService;
import metier.MatchService;

public class PlanifierMatchAction extends ActionSupport {
	@SuppressWarnings("unused")
	@Autowired
	private MatchService service;
	@SuppressWarnings("unused")
	@Autowired
	private JoueurService joueurService;
	private List<Joueur> lstJoueurs;
	private Map<Integer, String> mapJoueurs;
	private static final long serialVersionUID = 77971771589810L;

	private Match match;
	private List<Match> lstMatchs;

	public PlanifierMatchAction(@Autowired MatchService service, @Autowired JoueurService joueurService) {
		super();
		lstMatchs = service.recupererTousLesMatchs();
		//lstJoueurs = joueurService.recupererTousLesJoueurs();
		System.out.println("herrre");
		/*mapJoueurs = listToMap(joueurService.recupererTousLesJoueurs().stream()
				.map(e -> (Object) e)
			    .collect(Collectors.toList()));*/
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

	public List<Joueur> getLstJoueurs() {
		return lstJoueurs;
	}

	public void setLstJoueurs(List<Joueur> lstJoueurs) {
		this.lstJoueurs = lstJoueurs;
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
	 */
	private Map<Integer, String> listToMap(List<Object> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i = 0;
		for (Object obj : list) {
			switch (obj.getClass().getName())

			{

			case "Joueur":
				map.put(i, ((Joueur) obj).getNomJoueur());
				System.out.println("Match");
				break;

			default:

				/* Action */;

			}
			i++;
		}
		return map;
	}

}
