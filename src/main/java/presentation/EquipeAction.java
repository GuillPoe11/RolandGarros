package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Equipe;
import entite.Joueur;
import metier.EquipeService;
import metier.JoueurService;

public class EquipeAction extends ActionSupport {

	private static final long serialVersionUID = 59516144714998096L;

	@Autowired
	private EquipeService equipeService;

	private JoueurService joueurService;

	private Equipe equipe;

	private Integer idJoueur1;
	private Integer idJoueur2;
	private Joueur joueur1;
	private Joueur joueur2;
	private List<Joueur> lstJoueur;
	private Map<Integer, String> mapJoueur;

	private List<Equipe> lstEquipes;
	private List<Equipe> lstDixDernieresEquipes;
	

	private String msgForm;
	private String typeMsgForm; // alert alert-success alert-warning

	/*
	 * Constructeur
	 */
	public EquipeAction(@Autowired JoueurService serviceJ, @Autowired EquipeService equipeService) {
		lstJoueur = serviceJ.recupererTousLesJoueurs();
		mapJoueur = listToMap(serviceJ.recupererTousLesJoueurs());
		lstEquipes = equipeService.recupererToutesLesEquipes();
		lstDixDernieresEquipes = equipeService.recupererLesDixDernieresEquipes();
	}

	/**
	 * ajouter une équipe vérif si select bien pris en compte
	 * 
	 * @return success
	 */
	public String creerEquipe() {
		
		
		if (-1 == idJoueur1) {
			msgForm = "Choisissez le joueur1";
			typeMsgForm = "alert alert-danger";
		}
		else if (-1 == idJoueur2) {
			msgForm = "Choisissez le joueur2";
			typeMsgForm = "alert alert-danger";
		}
		else {
			joueur1 = lstJoueur.get(idJoueur1);
			joueur2 = lstJoueur.get(idJoueur2);
			equipeService.creerEquipe(joueur1, joueur2);
			msgForm = "L'équipe à été ajoutée";
			typeMsgForm = "alert alert-success";
		}

		return "success";
	}
	
	
	/**
	 * Permet de remplir une Map utilisée pour afficher le select sur la jsp à
	 * partir d'une liste de joueurs.
	 * 
	 * @param list
	 *            Une liste de Joueurs
	 * @return La HashMap dont les valeurs sont des chaines de caractères
	 *         correspondant aux noms et prénoms des joueurs et les clés des
	 *         entiers correspondant à l'indice des joueurs dans la liste
	 *         entrée en paramètre.
	 */
	private Map<Integer, String> listToMap(List<Joueur> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i = 0;
		for (Joueur joueur : list) {
			map.put(i, joueur.getNomJoueur() + " " + joueur.getPrenomJoueur());
			i++;
		}
		return map;
	}

	/*
	 * Getters/Setters
	 */
	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public EquipeService getEquipeService() {
		return equipeService;
	}

	public void setEquipeService(EquipeService equipeService) {
		this.equipeService = equipeService;
	}

	public JoueurService getJoueurService() {
		return joueurService;
	}

	public void setJoueurService(JoueurService joueurService) {
		this.joueurService = joueurService;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Joueur> getLstJoueur() {
		return lstJoueur;
	}

	public void setLstJoueur(List<Joueur> lstJoueur) {
		this.lstJoueur = lstJoueur;
	}

	public Map<Integer, String> getMapJoueur() {
		return mapJoueur;
	}

	public void setMapJoueur(Map<Integer, String> mapJoueur) {
		this.mapJoueur = mapJoueur;
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

	public List<Equipe> getLstEquipes() {
		return lstEquipes;
	}

	public void setLstEquipes(List<Equipe> lstEquipes) {
		this.lstEquipes = lstEquipes;
	}
	
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

	public List<Equipe> getLstDixDernieresEquipes() {
		return lstDixDernieresEquipes;
	}

	public void setLstDixDernieresEquipes(List<Equipe> lstDixDernieresEquipes) {
		this.lstDixDernieresEquipes = lstDixDernieresEquipes;
	}

}
