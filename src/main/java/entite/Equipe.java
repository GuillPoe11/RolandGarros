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

@Entity
@Table(name = "equipe")
public class Equipe {

	@Id
	@Column(name = "idEquipe", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEquipe;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdJoueur1")
	private Joueur joueur1;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdJoueur2")
	private Joueur joueur2;

	/*
	 * Constructeurs
	 */
	public Equipe() {

	}

	public Equipe(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	/*
	 * Getters/Setters
	 */

	public Integer getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Integer idEquipe) {
		this.idEquipe = idEquipe;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}
	// fin getters/setters

	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", joueur1=" + joueur1 + ", joueur2=" + joueur2 + "]";
	}

}
