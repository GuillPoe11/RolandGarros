package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arbitre")
public class Arbitre {

	@Id
	@Column(name = "idArbitre", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idArbitre;

	@Column(name = "nomArbitre", length = 150, nullable = false, unique = false)
	private String nomArbitre;

	@Column(name = "prenomArbitre", length = 150, nullable = false, unique = false)
	private String prenomArbitre;

	/*
	 * Constructeurs
	 */
	public Arbitre() {
	}

	public Arbitre(String nomArbitre, String prenomArbitre) {
		super();
		this.nomArbitre = nomArbitre;
		this.prenomArbitre = prenomArbitre;
	}

	/*
	 * Getters/Setters
	 */
	public Integer getIdArbitre() {
		return idArbitre;
	}

	public void setIdArbitre(Integer idArbitre) {
		this.idArbitre = idArbitre;
	}

	public String getNomArbitre() {
		return nomArbitre;
	}

	public void setNomArbitre(String nomArbitre) {
		this.nomArbitre = nomArbitre;
	}

	public String getPrenomArbitre() {
		return prenomArbitre;
	}

	public void setPrenomArbitre(String prenomArbitre) {
		this.prenomArbitre = prenomArbitre;
	}

	@Override
	public String toString() {
		return "Arbitre [idArbitre=" + idArbitre + ", nomArbitre=" + nomArbitre + ", prenomArbitre=" + prenomArbitre
				+ "]";
	}

	

}
