package presentation;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Arbitre;
import entite.Joueur;
import metier.ArbitreService;

public class ArbitreAction extends ActionSupport {

	@Autowired
	ArbitreService service;
	private static final long serialVersionUID = 77971771589810L;
	
	private Arbitre arbitre;

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
		if (arbitre.getNomArbitre() != null && !"".equals(arbitre.getNomArbitre()) && arbitre.getPrenomArbitre() != null && !"".equals(arbitre.getPrenomArbitre()) && arbitre.getNomArbitre().length() > 3
				&& arbitre.getPrenomArbitre().length() > 3 && verifArbitreExistants(arbitre.getNomArbitre(), arbitre.getPrenomArbitre())) {
			service.insererArbitre(arbitre.getNomArbitre(), arbitre.getPrenomArbitre());
		}
		return "success";
	}


	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
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
