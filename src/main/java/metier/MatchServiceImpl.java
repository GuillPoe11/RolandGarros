package metier;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.MatchDao;
import entite.Arbitre;
import entite.Court;
import entite.Equipe;
import entite.Joueur;
import entite.Match;
import entite.SousTournoi;

@Component
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;
	
	MatchServiceImpl(){
	}

	@Override
	public void creerMatch(Court court, Joueur joueur1, Joueur joueur2, Arbitre arbitre, SousTournoi sousTournoi,
			Date dateMatch, Equipe equipe1, Equipe equipe2) {

		Match match = new Match(court, joueur1, joueur2, arbitre, sousTournoi, dateMatch, equipe1, equipe2);
		matchDao.insererMatch(match);

	}

	@Override
	public void modifierMatch(Match match, Date dateMatch, Integer dureeMatch, Integer score1Match,
			Integer score2Match) {

		match.setDate(dateMatch);
		match.setDuree(dureeMatch);
		match.setScore1(score1Match);
		match.setScore2(score2Match);

		matchDao.modifier(match);
	}

	@Override
	public List<Match> recupererTousLesMatchs() {
		return matchDao.recupTousMatchs();
	}

	@Override
	public List<Match> recupererTousLesMatchsPourUnSousTournoi(SousTournoi sousTournoi) {

		return matchDao.recupTousMatchsPourUnSousTournoi(sousTournoi);
	}

}
