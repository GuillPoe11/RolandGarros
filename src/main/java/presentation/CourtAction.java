package presentation;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Court;
import metier.CourtService;

public class CourtAction extends ActionSupport{
	
	private static final long serialVersionUID = 2446885132270963769L;

	@Autowired
	private CourtService cService;
	
	//private Court court;
	
	private String nomCourt;
	private String numeroCourt;
	
	/*
	 * Constructeur
	 */
	public CourtAction()
	{
		
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
	
	public String ajouterCourt() {

		System.out.println("Essai ajout d'un court");

		cService.insererCourt(nomCourt, numeroCourt);
		
		return "SUCCESS";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
