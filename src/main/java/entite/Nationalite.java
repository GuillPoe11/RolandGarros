package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nationalite")
public class Nationalite {

	@Id
	@Column(name = "idNationalite", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idNationalite;

	@Column(name = "libelleNationalite", length = 150, nullable = false, unique = true)
	private String libelleNationalite;

	/*
	 * Constructeurs
	 */
	public Nationalite() {

	}

	public Nationalite(String libelleNationalite) {
		this.libelleNationalite = libelleNationalite;

	}

	/*
	 * Getters/Setters
	 */

	public Integer getIdNationalite() {
		return idNationalite;
	}

	public void setIdNationalite(Integer idNationalite) {
		this.idNationalite = idNationalite;
	}

	public String getLibelleNationalite() {
		return libelleNationalite;
	}

	public void setLibelleNationalite(String libelleNationalite) {
		this.libelleNationalite = libelleNationalite;
	}
	// fin getters/setters

	@Override
	public String toString() {
		return "Nationalite [idNationalite=" + idNationalite + ", libelleNationalite=" + libelleNationalite + "]";
	}

}
