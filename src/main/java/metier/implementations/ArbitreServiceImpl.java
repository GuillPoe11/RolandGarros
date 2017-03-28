package metier.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.interfaces.ArbitreDao;
import entite.Arbitre;
import metier.interfaces.ArbitreService;

@Service
public class ArbitreServiceImpl implements ArbitreService {

	@Autowired
	private ArbitreDao nDao;

	public ArbitreServiceImpl() {
	}

	@Override
	public List<Arbitre> recupTousArbitres() {
		return nDao.recupTousLesArbitres();
	}

	@Override
	public List<Arbitre> recupLesDixDerniersArbitres() {
		return nDao.recupLesDixDerniersArbitres();
	}

	@Override
	public Arbitre recupArbitreParId(int id) {
		return nDao.recupArbitreParId(id);
	}

	@Override
	public void insererArbitre(String nomArbitre, String prenomArbitre) {
		nDao.insererArbitre(new Arbitre(nomArbitre, prenomArbitre));
	}

}
