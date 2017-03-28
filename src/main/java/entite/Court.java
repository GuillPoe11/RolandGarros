package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "court")
public class Court {

	@Id
	@Column(name = "idCourt", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCourt;

	@Column(name = "nomCourt", length = 150, nullable = false, unique = true)
	private String nomCourt;

	@Column(name = "numeroCourt", length = 20, nullable = false, unique = true)
	private String numeroCourt;

	/*
	 * Constructeurs
	 */

	public Court() {
	}

	public Court(String nomCourt, String numeroCourt) {
		super();
		this.nomCourt = nomCourt;
		this.numeroCourt = numeroCourt;
	}

	/*
	 * Getters/Setters
	 */

	public Integer getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(Integer idCourt) {
		this.idCourt = idCourt;
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
	// fin getters/setters

	@Override
	public String toString() {
		return "Court [idCourt=" + idCourt + ", nomCourt=" + nomCourt + ", numeroCourt=" + numeroCourt + "]";
	}

}
