package metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MatchDao;
import entite.Arbitre;
import entite.Court;
import entite.Equipe;
import entite.Joueur;
import entite.Match;
import entite.SousTournoi;
import metier.exception.MatchException;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;

	MatchServiceImpl() {
	}

	@Override
	public void creerMatch(Court court, Joueur joueur1, Joueur joueur2, Arbitre arbitre, SousTournoi sousTournoi,
			Date dateMatch, Equipe equipe1, Equipe equipe2) throws MatchException {
		validation(court, joueur1, joueur2, arbitre, sousTournoi, dateMatch, equipe1, equipe2);

		Match match = new Match(court, joueur1, joueur2, arbitre, sousTournoi, dateMatch, equipe1, equipe2);
		matchDao.insererMatch(match);
	}

	/**
	 * Modifie le score1,score2 et duree d'un match à partir d'un match
	 * 
	 * @param Match
	 *            : le match
	 * @param dateMatch
	 *            : Date la nouvelle date du match
	 * @param dureeMatch
	 *            : int la duréé
	 * @param score1Match
	 *            : int le score1 du match
	 * @param score2Match
	 *            : int le score2 du match
	 */
	@Override
	public void modifierMatch(Match match, Date dateMatch, Integer dureeMatch, Integer score1Match,
			Integer score2Match) {

		match.setDateMatch(dateMatch);
		match.setDureeMatch(dureeMatch);
		match.setScore1(score1Match);
		match.setScore2(score2Match);

		matchDao.modifier(match);
	}

	@Override
	public List<Match> recupererTousLesMatchs() {
		return matchDao.recupTousMatchs();
	}

	@Override
	public List<Match> recupererLesDixDerniersMatchs() {
		return matchDao.recupLesDixDerniersMatchs();
	}

	@Override
	public List<Match> recupererTousLesMatchsPourUnSousTournoi(SousTournoi sousTournoi) {

		return matchDao.recupTousMatchsPourUnSousTournoi(sousTournoi);
	}

	private void validation(Court court, Joueur joueur1, Joueur joueur2, Arbitre arbitre, SousTournoi sousTournoi,
			Date dateMatch, Equipe equipe1, Equipe equipe2) throws MatchException {
		// vérif cas tournoi mixte en équipe
		if (sousTournoi.getGenreSousTournoi() == 'M' && sousTournoi.getTypeSousTournoi() == 'E') {
			if (equipeUnisexe(equipe1) || equipeUnisexe(equipe2)) {
				throw new MatchException("Les équipes doivent être mixtes pour ce type de tournoi");
			}
		}
		// vérif cas tournoi homme en équipe
		if (sousTournoi.getGenreSousTournoi() == 'H' && sousTournoi.getTypeSousTournoi() == 'E') {
			if (!equipeUnisexe(equipe1) || !equipeUnisexe(equipe2)) {
				throw new MatchException("Les équipes ne peuvent pas êtres mixtes pour ce type de tournoi");
			}
			if (equipe1.getJoueur1().getSexeJoueur() != 'M' || equipe1.getJoueur2().getSexeJoueur() != 'M'
					|| equipe2.getJoueur1().getSexeJoueur() != 'M' || equipe2.getJoueur2().getSexeJoueur() != 'M') {
				throw new MatchException("Les joueurs doivent être des hommes pour ce type de tournoi");
			}
		}
		// vérif cas tournoi femme en équipe
		if (sousTournoi.getGenreSousTournoi() == 'F' && sousTournoi.getTypeSousTournoi() == 'E') {
			if (!equipeUnisexe(equipe1) || !equipeUnisexe(equipe2)) {
				throw new MatchException("Les équipes ne peuvent pas êtres mixtes pour ce type de tournoi");
			}
			if (equipe1.getJoueur1().getSexeJoueur() != 'F' || equipe1.getJoueur2().getSexeJoueur() != 'F'
					|| equipe2.getJoueur1().getSexeJoueur() != 'F' || equipe2.getJoueur2().getSexeJoueur() != 'F') {
				throw new MatchException("Les joueurs doivent être des femmes pour ce type de tournoi");
			}
		}
		// vérif cas tournoi homme simple
		if (sousTournoi.getGenreSousTournoi() == 'H' && sousTournoi.getTypeSousTournoi() == 'S') {
			if (joueur1.getSexeJoueur() != 'M' || joueur2.getSexeJoueur() != 'M') {
				throw new MatchException("Les joueurs doivent être des hommes pour ce type de tournoi");
			}
		}
		// vérif cas tournoi femme simple
		if (sousTournoi.getGenreSousTournoi() == 'F' && sousTournoi.getTypeSousTournoi() == 'S') {
			if (joueur1.getSexeJoueur() != 'F' || joueur2.getSexeJoueur() != 'F') {
				throw new MatchException("Les joueurs doivent être des femmes pour ce type de tournoi");
			}
		}
		// vérif cas : un joueur ne joue pas contre lui-même (simple)
		if (sousTournoi.getTypeSousTournoi() == 'S') {
			if (joueur1.equals(joueur2)) {
				throw new MatchException("Un joueur ne peut jouer contre lui-même");
			}
		}
		// vérif cas : un joueur ne joue pas contre lui-même (équipe)
		if (sousTournoi.getTypeSousTournoi() == 'E') {
			if ((equipe1.getJoueur1().equals(equipe2.getJoueur1()) || equipe1.getJoueur1().equals(equipe2.getJoueur2()))
					|| (equipe1.getJoueur2().equals(equipe2.getJoueur1())
							|| equipe1.getJoueur2().equals(equipe2.getJoueur2()))
					|| (equipe2.getJoueur1().equals(equipe1.getJoueur1())
							|| equipe2.getJoueur1().equals(equipe1.getJoueur2()))
					|| (equipe2.getJoueur2().equals(equipe1.getJoueur1())
							|| equipe2.getJoueur1().equals(equipe1.getJoueur2()))) {
				throw new MatchException("Un joueur ne peut jouer contre lui-même");
			}
		}
		// vérif cas : unjoueur ne peut jouer avec lui-même
		if (sousTournoi.getTypeSousTournoi() == 'E') {
			if (equipe1.getJoueur1().equals(equipe1.getJoueur2())
					|| equipe2.getJoueur1().equals(equipe2.getJoueur2())) {
				throw new MatchException("Un joueur ne peut jouer avec lui-même");
			}
		}
	}

	private boolean equipeUnisexe(Equipe equipe) {
		return equipe.getJoueur1().getSexeJoueur().equals(equipe.getJoueur2().getSexeJoueur());
	}

}
