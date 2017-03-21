package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "joueur")
public class Joueur {

	@Id
	@Column(name = "idJoueur", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idJoueur;

	@Column(name = "nomJoueur", length = 100, nullable = false, unique = false)
	private String nomJoueur;

	@Column(name = "prenomJoueur", length = 100, nullable = false, unique = false)
	private String prenomJoueur;

	@Column(name = "sexeJoueur", length = 1, nullable = false, unique = false)
	private Character sexeJoueur;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idNationalite")
	private Nationalite refIdNationalite;

	/*
	 * Constructeurs
	 */
	public Joueur() {

	}

	public Joueur(String nomJoueur, String prenomJoueur, Character sexeJoueur, Nationalite refIdNationalite) {

		this.nomJoueur = nomJoueur;
		this.prenomJoueur = prenomJoueur;
		this.sexeJoueur = sexeJoueur;
		this.refIdNationalite = refIdNationalite;
	}

	/*
	 * Getters/Setters
	 */
	public Integer getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Integer idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getPrenomJoueur() {
		return prenomJoueur;
	}

	public void setPrenomJoueur(String prenomJoueur) {
		this.prenomJoueur = prenomJoueur;
	}

	public Character getSexeJoueur() {
		return sexeJoueur;
	}

	public void setSexeJoueur(Character sexeJoueur) {
		this.sexeJoueur = sexeJoueur;
	}

	public Nationalite getRefIdNationalite() {
		return refIdNationalite;
	}

	public void setRefIdNationalite(Nationalite refIdNationalite) {
		this.refIdNationalite = refIdNationalite;
	}

}