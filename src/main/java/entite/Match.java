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

@SuppressWarnings("unused")
@Entity
@Table(name = "match")
public class Match {

	@Id
	@Column(name = "idMatch", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMatch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCourt")
	private Court court;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idJoueur")
	private Joueur prenomJoueur;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idJoueur")
	private Joueur joueur2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idArbitre")
	private Arbitre arbitre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSousTournoi")
	private SousTournoi sousTournoi;

	@Column(name = "date", nullable = false, unique = false)
	private Date date;

	@Column(name = "duree", length = 100, nullable = false, unique = false)
	private String duree;

	@Column(name = "score", length = 100, nullable = false, unique = false)
	private String score;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEquipe")
	private Equipe equipe1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEquipe")
	private Equipe equipe2;

	@Column(name = "score1", nullable = false, unique = false)
	private int score1;

	@Column(name = "score2", nullable = false, unique = false)
	private int score2;

	/*
	 * Constructeurs
	 */
	public Match() {

	}

	public Match(Integer idMatch, Court court, Joueur prenomJoueur, Joueur joueur2, Arbitre arbitre,
			SousTournoi sousTournoi, Date date, String duree, Equipe equipe1, Equipe equipe2, int score1, int score2) {
		super();
		this.idMatch = idMatch;
		this.court = court;
		this.prenomJoueur = prenomJoueur;
		this.joueur2 = joueur2;
		this.arbitre = arbitre;
		this.sousTournoi = sousTournoi;
		this.date = date;
		this.duree = duree;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.score1 = score1;
		this.score2 = score2;
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

	public Joueur getPrenomJoueur() {
		return prenomJoueur;
	}

	public void setPrenomJoueur(Joueur prenomJoueur) {
		this.prenomJoueur = prenomJoueur;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

}