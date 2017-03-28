package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Joueur;
import entite.Nationalite;
import metier.interfaces.JoueurService;
import metier.interfaces.NationaliteService;

/**
 * Action qui permet de gérer l'ajout de joueur
 * 
 * @author eric.poe11
 *
 */
public class JoueurAction extends ActionSupport {

	private static final long serialVersionUID = -2439182379487460604L;

	@Autowired
	private JoueurService joueurService;

	@SuppressWarnings("unused")
	private NationaliteService nationaliteService;

	private Joueur joueur;

	private Integer idNationalite;
	private List<Joueur> lstJoueurs;
	private List<Joueur> lstDixDerniersJoueurs;
	private List<Nationalite> lstNationalites;
	private Map<Integer, String> mapNationalites;

	private String msgForm;
	private String typeMsgForm;

	/**
	 * Constructeur de l'action. Force l'injection des services pour pouvoir
	 * charger les listes de joueurs et de nationalités
	 * 
	 * @param nationaliteService
	 *            Le service NationaliteService
	 * @param joueurService
	 *            Le service JoueurService
	 */
	public JoueurAction(@Autowired NationaliteService nationaliteService, @Autowired JoueurService joueurService) {
		joueur = new Joueur();
		lstJoueurs = joueurService.recupererTousLesJoueurs();
		// lstDixDerniersJoueurs = joueurService.recupLesDixDerniersJoueurs();
		lstNationalites = nationaliteService.recupToutesNationalites();
		mapNationalites = listToMap(nationaliteService.recupToutesNationalites());
	}

	/**
	 * Crée un joueur avec les données entrées dans le formulaire de joueur.jsp
	 * 
	 * @return renvoie "success" qui permet de recharger la page joueur.jsp
	 */
	public String creerJoueur() {
		if (validation()) {
			Nationalite nationalite = lstNationalites.get(idNationalite);
			joueurService.creerJoueur(joueur.getNomJoueur(), joueur.getPrenomJoueur(), joueur.getSexeJoueur(),
					nationalite);
			// pour mise à jour de la liste des joueurs
			lstJoueurs = joueurService.recupererTousLesJoueurs();
		}
		return "success";
	}

	/**
	 * Vérifie que les champs du formulaire sont remplis
	 * 
	 * @return true si les champs sont remplis, false sinon
	 */
	private boolean validation() {
		boolean valide = true;
		if (joueur.getNomJoueur() != null && joueur.getNomJoueur().length() == 0) {
			msgForm = "Le nom est obligatoire";
			typeMsgForm = "alert alert-danger";
			valide = false;
		} else if (joueur.getPrenomJoueur() != null && joueur.getPrenomJoueur().length() == 0) {
			msgForm = "Le prénom est obligatoire";
			typeMsgForm = "alert alert-danger";
			valide = false;
		} else if (joueur.getSexeJoueur() != null && joueur.getSexeJoueur() < 0) {
			msgForm = "Le sexe doit être défini";
			typeMsgForm = "alert alert-danger";
			valide = false;
		} else if (idNationalite != null && idNationalite < 0) {
			msgForm = "La nationalité est obligatoire";
			typeMsgForm = "alert alert-danger";
			valide = false;
		} else {
			msgForm = "Le joueur " + joueur.getPrenomJoueur() + " " + joueur.getNomJoueur() + " a été créé";
			typeMsgForm = "alert alert-success";
		}
		return valide;
	}

	// Ne fonctionne pas à cause du thème simple
	// public void validate(){
	// if (joueur.getNomJoueur() != null && joueur.getNomJoueur().length() == 0)
	// {
	// addFieldError("joueur.nomJoueur", "Le nom est obligatoire");
	// }
	// if (joueur.getPrenomJoueur() != null && joueur.getPrenomJoueur().length()
	// == 0) {
	// addFieldError("joueur.prenomJoueur", "Le prénom est obligatoire");
	// }
	// if (joueur.getSexeJoueur() == null) {
	// addFieldError("joueur.sexeJoueur", "Le sexe doit être défini");
	// }
	// if (idNationalite != null && idNationalite < 0) {
	// addFieldError("idNationalite", "La nationalité est obligatoire");
	// }
	// }

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

	public List<Joueur> getLstJoueurs() {
		return lstJoueurs;
	}

	public void setLstJoueurs(List<Joueur> lstJoueurs) {
		this.lstJoueurs = lstJoueurs;
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

	public List<Joueur> getLstDixDerniersJoueurs() {
		return lstDixDerniersJoueurs;
	}

	public void setLstDixDerniersJoueurs(List<Joueur> lstDixDerniersJoueurs) {
		this.lstDixDerniersJoueurs = lstDixDerniersJoueurs;
	}

}
