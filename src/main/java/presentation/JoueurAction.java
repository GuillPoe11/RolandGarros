package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Joueur;
import entite.Nationalite;
import metier.JoueurService;
import metier.NationaliteService;

public class JoueurAction extends ActionSupport {

	private static final long serialVersionUID = -2439182379487460604L;

	@Autowired
	private JoueurService joueurService;

	@SuppressWarnings("unused")
	private NationaliteService nationaliteService;

	private Joueur joueur;

	private Integer idNationalite;
	private List<Joueur> lstJoueurs;
	private List<Nationalite> lstNationalites;
	private Map<Integer, String> mapNationalites;

	private String message;

	public JoueurAction(@Autowired NationaliteService nationaliteService, @Autowired JoueurService joueurService) {
		lstJoueurs = joueurService.recupererTousLesJoueurs();
		lstNationalites = nationaliteService.recupToutesNationalites();
		mapNationalites = listToMap(nationaliteService.recupToutesNationalites());
	}

	/**
	 * Crée un joueur avec les données entrées dans le formulaire de joueur.jsp
	 * 
	 * @return renvoie "success" qui permet de recharger la page joueur.jsp
	 */
	public String creerJoueur() {
		Nationalite nationalite = lstNationalites.get(idNationalite);
		joueurService.creerJoueur(joueur.getNomJoueur(), joueur.getPrenomJoueur(), joueur.getSexeJoueur(), nationalite);
		message = "Le joueur " + joueur.getPrenomJoueur() + " " + joueur.getNomJoueur() + " a été créé";
		return "success";
	}

	/**
	 * Permet de remplir une Map utilisée pour afficher le select sur la jsp à
	 * partir d'une liste de nationalités.
	 * 
	 * @param list
	 *            Une liste de Nationalités
	 * @return La HashMap dont les valeurs sont des chaines de caractères
	 *         correspondant aux libellés des nationalités et les clés des
	 *         entiers correspondant à l'indice des nationalités dans la liste
	 *         entrée en paramètre.
	 */
	private Map<Integer, String> listToMap(List<Nationalite> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i = 0;
		for (Nationalite nationalite : list) {
			map.put(i, nationalite.getLibelleNationalite());
			i++;
		}
		return map;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Map<Integer, String> getMapNationalites() {
		return mapNationalites;
	}

	public void setMapNationalites(Map<Integer, String> mapNationalites) {
		this.mapNationalites = mapNationalites;
	}

	public Integer getIdNationalite() {
		return idNationalite;
	}

	public void setIdNationalite(Integer idNationalite) {
		this.idNationalite = idNationalite;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Joueur> getLstJoueurs() {
		return lstJoueurs;
	}

	public void setLstJoueurs(List<Joueur> lstJoueurs) {
		this.lstJoueurs = lstJoueurs;
	}

}
