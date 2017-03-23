package entite;

import java.util.Date;

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
@Table(name = "match")
public class Match {

	@Id
	@Column(name = "idMatch", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMatch;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdCourt")
	private Court court;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdJoueur1")
	private Joueur joueur1;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdJoueur2")
	private Joueur joueur2;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdArbitre")
	private Arbitre arbitre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdSousTournoi")
	private SousTournoi sousTournoi;

	@Column(name = "dateMatch", nullable = false, unique = false)
	private Date dateMatch;

	@Column(name = "dureeMatch", nullable = true, unique = false)
	private Integer dureeMatch;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdEquipe1")
	private Equipe equipe1;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refIdEquipe2")
	private Equipe equipe2;

	@Column(name = "score1", nullable = true, unique = false)
	private Integer score1;

	@Column(name = "score2", nullable = true, unique = false)
	private Integer score2;

	/*
	 * Constructeurs
	 */
	public Match() {

	}

	public Match(Court court, Joueur joueur1, Joueur joueur2, Arbitre arbitre, SousTournoi sousTournoi, Date dateMatch,
			Equipe equipe1, Equipe equipe2) {
		super();
		this.court = court;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.arbitre = arbitre;
		this.sousTournoi = sousTournoi;
		this.dateMatch = dateMatch;
	}

	/*
	 * Getters/Setters
	 */

	public Integer getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
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

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	public SousTournoi getSousTournoi() {
		return sousTournoi;
	}

	public void setSousTournoi(SousTournoi sousTournoi) {
		this.sousTournoi = sousTournoi;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date date) {
		this.dateMatch = date;
	}

	public Integer getDureeMatch() {
		return dureeMatch;
	}

	public void setDureeMatch(Integer duree) {
		this.dureeMatch = duree;
	}

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

	public Integer getScore1() {
		return score1;
	}

	public void setScore1(Integer score1) {
		this.score1 = score1;
	}

	public Integer getScore2() {
		return score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}

	/*
	 * TO string
	 */

	@Override
	public String toString() {
		return "Match [idMatch=" + idMatch + ", court=" + court + ", joueur1=" + joueur1 + ", joueur2=" + joueur2
				+ ", arbitre=" + arbitre + ", sousTournoi=" + sousTournoi + ", dateMatch=" + dateMatch + ", dureeMatch="
				+ dureeMatch + ", equipe1=" + equipe1 + ", equipe2=" + equipe2 + ", score1=" + score1 + ", score2="
				+ score2 + "]";
	}

}