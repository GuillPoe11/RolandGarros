package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organisateur")
public class Organisateur {

	@Id
	@Column(name = "idOrganisateur", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOrganisateur;

	@Column(name = "loginOrganisateur", length = 150, nullable = false, unique = false)
	private String loginOrganisateur;

	@Column(name = "passwordOrganisateur", length = 150, nullable = false, unique = false)
	private String passwordOrganisateur;

	/*
	 * Constructeurs
	 */
	public Organisateur() {

	}

	public Organisateur(String loginOrganisateur, String passwordOrganisateur) {
		super();
		this.loginOrganisateur = loginOrganisateur;
		this.passwordOrganisateur = passwordOrganisateur;
	}

	/*
	 * Getters/Setters
	 */

	public Integer getIdOrganisateur() {
		return idOrganisateur;
	}

	public void setIdOrganisateur(Integer idOrganisateur) {
		this.idOrganisateur = idOrganisateur;
	}

	public String getLoginOrganisateur() {
		return loginOrganisateur;
	}

	public void setLoginOrganisateur(String loginOrganisateur) {
		this.loginOrganisateur = loginOrganisateur;
	}

	public String getPasswordOrganisateur() {
		return passwordOrganisateur;
	}

	public void setPasswordOrganisateur(String passwordOrganisateur) {
		this.passwordOrganisateur = passwordOrganisateur;
	}
	//fin getters/Setters

	@Override
	public String toString() {
		return "Organisateur [idOrganisateur=" + idOrganisateur + ", loginOrganisateur=" + loginOrganisateur
				+ ", passwordOrganisateur=" + passwordOrganisateur + "]";
	}
	
	

}