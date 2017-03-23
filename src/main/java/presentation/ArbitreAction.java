package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Arbitre;
import metier.ArbitreService;

public class ArbitreAction extends ActionSupport {
	@Autowired
	private ArbitreService service;
	private static final long serialVersionUID = 77971771589810L;

	private Arbitre arbitre;
	private List<Arbitre> lstArbitres;
	private Map<Integer, String> lstTypeArbitres;

	public ArbitreAction(@Autowired ArbitreService service) {
		super();
		lstArbitres = service.recupTousArbitres();
		lstTypeArbitres = new HashMap<Integer, String>();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Fonction qui ajoute un arbitre lorsque l'organisateur clique sur le
	 * bouton refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * 
	 */
	public String submite() {
		if (arbitre.getNomArbitre() != null && !"".equals(arbitre.getNomArbitre()) && arbitre.getPrenomArbitre() != null
				&& !"".equals(arbitre.getPrenomArbitre()) && arbitre.getNomArbitre().length() > 3
				&& arbitre.getPrenomArbitre().length() > 3
				&& verifArbitreExistants(arbitre.getNomArbitre(), arbitre.getPrenomArbitre())) {
			service.insererArbitre(arbitre.getNomArbitre(), arbitre.getPrenomArbitre());
			arbitre.setNomArbitre("");
			arbitre.setPrenomArbitre("");
			lstArbitres = service.recupTousArbitres();
		}
		return "success";
	}

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	public List<Arbitre> getLstArbitres() {
		return lstArbitres;
	}

	public void setLstArbitres(List<Arbitre> lstArbitres) {
		this.lstArbitres = lstArbitres;
	}

	public Map<Integer, String> getLstTypeArbitres() {
		return lstTypeArbitres;
	}

	public void setLstTypeArbitres(Map<Integer, String> lstTypeArbitres) {
		this.lstTypeArbitres = lstTypeArbitres;
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
