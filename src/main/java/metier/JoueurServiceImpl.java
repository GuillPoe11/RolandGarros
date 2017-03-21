package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.JoueurDao;
import entite.Joueur;
import entite.Nationalite;

public class JoueurServiceImpl implements JoueurService {

	@Autowired
	private JoueurDao jDao;

	/*
	 * Constructeurs
	 */
	private JoueurServiceImpl() {
	}

	/*
	 * Création d'un joueur
	 */
	@Override
	public void creerJoueur(String nomJoueur, String prenomJoueur, Character sexeJoueur, Nationalite nationalite) {
		Joueur j = new Joueur(nomJoueur, prenomJoueur, sexeJoueur, nationalite);
		jDao.insererJoueur(j);

	}

	/*
	 * Récupération d'un joueur par Id
	 */
	@Override
	public Joueur recupererJoueurParId(int idJoueur) {
		Joueur j = jDao.recupJoueurParId(idJoueur);
		return j;
	}

	/*
	 * Récupération de la liste des joueurs
	 */
	@Override
	public List<Joueur> recupererTousLesJoueurs() {
		return jDao.recupTousLesJoueurs();
	}

}
