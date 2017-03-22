package presentation;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Arbitre;
import metier.ArbitreService;

public class ArbitreAction extends ActionSupport {

	@Autowired
	ArbitreService service;
	private static final long serialVersionUID = 77971771589810L;
	private String nom;
	private String prenom;

	public ArbitreAction() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Fonction qui ajoute un arbitre lorsque l'organisateur clique sur le
	 * bouton refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * @return
	 */
	public String submit() {
		if (nom != null && !"".equals(nom) && prenom != null && !"".equals(prenom) && nom.length() > 3
				&& prenom.length() > 3 && verifArbitreExistants(nom, prenom)) {
			service.insererArbitre(nom, prenom);
		}
		return "success";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Fonction de vérification si un arbitre existe déjà
	 * 
	 * @param nom
	 * @param prenom
	 * @return true or false
	 */
	public boolean verifArbitreExistants(String nom, String prenom) {
		for (Arbitre arb : service.recupTousArbitres()) {
			if (arb.getNomArbitre().equals(nom) && arb.getPrenomArbitre().equals(prenom)) {
				return false;
			}
		}
		return true;
	}

}
