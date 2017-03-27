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
	private List<Arbitre> lstdixArbitres;
	private Map<Integer, String> lstTypeArbitres;
	private String msgForm;
	private String typeMsgForm; // alert alert-success alert-warning

	public ArbitreAction(@Autowired ArbitreService service) {
		super();
		lstArbitres = service.recupTousArbitres();
		//lstdixArbitres = service.recupLesDixDerniersArbitres();
		lstdixArbitres = service.recupTousArbitres();
		lstTypeArbitres = new HashMap<Integer, String>();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	public List<Arbitre> getLstdixArbitres() {
		return lstdixArbitres;
	}

	public void setLstdixArbitres(List<Arbitre> lstdixArbitres) {
		this.lstdixArbitres = lstdixArbitres;
	}
	
	// fin getters/setters

	

	/**
	 * Fonction qui ajoute un arbitre lorsque l'organisateur clique sur le
	 * bouton refuse l'ajout si les conditions ne sont pas respectées
	 * 
	 * return string vers la page arbitre
	 */
	public String submite() {
		if (arbitre.getNomArbitre() == null || "".equals(arbitre.getNomArbitre())
				) {
			msgForm = "nom incorrect";
			typeMsgForm = "alert alert-danger";
			
		} 
		else if(verifArbitreExistants(arbitre.getNomArbitre(), arbitre.getPrenomArbitre())){
		}
		else if(arbitre.getPrenomArbitre() == null
				|| "".equals(arbitre.getPrenomArbitre())){
			msgForm = "prénom incorrect";
			typeMsgForm = "alert alert-danger";
		}
		else if(arbitre.getNomArbitre().length() < 3
				&& arbitre.getPrenomArbitre().length() < 3){
			msgForm = "Minimum 3 caractères";
			typeMsgForm = "alert alert-danger";
		}
		else{
			service.insererArbitre(arbitre.getNomArbitre(), arbitre.getPrenomArbitre());
			arbitre.setNomArbitre("");
			arbitre.setPrenomArbitre("");
			lstdixArbitres = service.recupTousArbitres();
		}
		return "success";
	}

	/**
	 * Fonction de vérification si un arbitre existe déjà
	 * 
	 * @param nom
	 * @param prenom
	 * @return true or false
	 */
	private boolean verifArbitreExistants(String nom, String prenom) {
		for (Arbitre arb : service.recupTousArbitres()) {
			if (arb.getNomArbitre().equals(nom) && arb.getPrenomArbitre().equals(prenom)) {
				msgForm = "Arbitre déjà existant";
				typeMsgForm = "alert alert-danger";
				return true;
			}
		}
		return false;
	}

}
