package metier.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.interfaces.EquipeDao;
import entite.Equipe;
import entite.Joueur;
import metier.exception.EquipeException;
import metier.interfaces.EquipeService;

@Service
public class EquipeServiceImpl implements EquipeService {

	@Autowired
	private EquipeDao equipeDao;

	public EquipeServiceImpl() {
	}

	@Override
	public void creerEquipe(Joueur joueur1, Joueur joueur2) throws EquipeException {
		validation(joueur1, joueur2);
		Equipe equipe = new Equipe(joueur1, joueur2);
		equipeDao.insererEquipe(equipe);
	}

	@Override
	public Equipe recupererEquipeParId(Integer idEquipe) {
		return equipeDao.recupEquipeParId(idEquipe);
	}

	@Override
	public List<Equipe> recupererToutesLesEquipes() {
		return equipeDao.recupToutesEquipes();
	}

	@Override
	public List<Equipe> recupererLesDixDernieresEquipes() {
		return equipeDao.recupLes10DernieresEquipes();
	}

	private void validation(Joueur joueur1, Joueur joueur2) throws EquipeException {
		if (joueur1.equals(joueur2)) {
			throw new EquipeException("Un joueur ne peut jouer avec lui-même");
		}
	}
}
