package presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Court;
import metier.CourtService;

public class CourtAction extends ActionSupport {

	private static final long serialVersionUID = 2446885132270963769L;

	@Autowired
	private CourtService cService;

	// private Court court;

	private String nomCourt;
	private String numeroCourt;

	private String msgForm;
	private String typeMsgForm; // alert alert-success alert-warning

	private List<Court> lstCourts;

	/*
	 * Constructeur
	 */
	public CourtAction(@Autowired CourtService cService) {
		 lstCourts = cService.recupTousCourts();
	}

	/*
	 * Getters / Setters
	 */
	public CourtService getcService() {
		return cService;
	}

	public void setcService(CourtService cService) {
		this.cService = cService;
	}

	public String getNomCourt() {
		return nomCourt;
	}

	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}

	public String getNumeroCourt() {
		return numeroCourt;
	}

	public void setNumeroCourt(String numeroCourt) {
		this.numeroCourt = numeroCourt;
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

	public List<Court> getLstCourts() {
		return lstCourts;
	}

	public void setLstCourts(List<Court> lstCourts) {
		this.lstCourts = lstCourts;
	}
	//fin getters/setters
		
	public String ajouterCourt() {

		System.out.println("Essai ajout d'un court");
		if ("".equals(nomCourt)) {
			msgForm = "Le nom du court ne peut-être vide";
			typeMsgForm = "alert alert-danger";
		} else if ("".equals(numeroCourt)) {
			msgForm = "Le numero du court ne peut-être vide";
			typeMsgForm = "alert alert-danger";
		} else {
			cService.insererCourt(nomCourt, numeroCourt);
			msgForm = "Le court à été ajouté";
			typeMsgForm = "alert alert-success";
			System.out.println("Ajout court ok");
		}
		return "success";
	}

}
