package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.EquipeDao;
import entite.Equipe;
import entite.Joueur;

@Component
public class EquipeServiceImpl implements EquipeService {
	
	@Autowired
	private EquipeDao equipeDao;

	public EquipeServiceImpl() {
	}

	@Override
	public void creerEquipe(Joueur joueur1, Joueur joueur2) {
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

}
