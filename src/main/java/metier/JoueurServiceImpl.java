package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.JoueurDao;
import entite.Joueur;
import entite.Nationalite;

@Service
public class JoueurServiceImpl implements JoueurService {

	@Autowired
	private JoueurDao jDao;

	private JoueurServiceImpl() {
	}

	@Override
	public void creerJoueur(String nomJoueur, String prenomJoueur, Character sexeJoueur, Nationalite nationalite) {
		Joueur j = new Joueur(nomJoueur, prenomJoueur, sexeJoueur, nationalite);
		jDao.insererJoueur(j);

	}

	@Override
	public Joueur recupererJoueurParId(int idJoueur) {
		Joueur j = jDao.recupJoueurParId(idJoueur);
		return j;
	}

	@Override
	public List<Joueur> recupererTousLesJoueurs() {
		return jDao.recupTousLesJoueurs();
	}

	@Override
	public List<Joueur> recupLesDixDerniersJoueurs() {
		return jDao.recupLesDixDerniersJoueurs();
	}

}
