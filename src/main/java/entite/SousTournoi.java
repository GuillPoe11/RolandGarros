package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "soustournoi")
public class SousTournoi {

	@Id
	@Column(name = "idSousTournoi", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSousTournoi;

	@Column(name = "nomSousTournoi", length = 150, nullable = false, unique = true)
	private String nomSousTournoi;

	@Column(name = "nbJoueursSousTournoi", length = 1, nullable = false, unique = true)
	private Integer nbJoueursSousTournoi;

	@Column(name = "genreSousTournoi", nullable = false, unique = true)
	private Character genreSousTournoi;

	/*
	 * Constructeurs
	 */

	public SousTournoi() {
	}

	public SousTournoi(Integer idSousTournoi, String nomSousTournoi, Integer nbJoueursSousTournoi,
			Character genreSousTournoi) {
		super();
		this.idSousTournoi = idSousTournoi;
		this.nomSousTournoi = nomSousTournoi;
		this.nbJoueursSousTournoi = nbJoueursSousTournoi;
		this.genreSousTournoi = genreSousTournoi;
	}

	/*
	 * Getters/Setters
	 */

	public Integer getIdSousTournoi() {
		return idSousTournoi;
	}

	public void setIdSousTournoi(Integer idSousTournoi) {
		this.idSousTournoi = idSousTournoi;
	}

	public String getNomSousTournoi() {
		return nomSousTournoi;
	}

	public void setNomSousTournoi(String nomSousTournoi) {
		this.nomSousTournoi = nomSousTournoi;
	}

	public Integer getNbJoueursSousTournoi() {
		return nbJoueursSousTournoi;
	}

	public void setNbJoueursSousTournoi(Integer nbJoueursSousTournoi) {
		this.nbJoueursSousTournoi = nbJoueursSousTournoi;
	}

	public Character getGenreSousTournoi() {
		return genreSousTournoi;
	}

	public void setGenreSousTournoi(Character genreSousTournoi) {
		this.genreSousTournoi = genreSousTournoi;
	}

}
