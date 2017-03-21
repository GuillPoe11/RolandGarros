package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ArbitreDao;
import entite.Arbitre;

@Component
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
	public Arbitre recupArbitreParId(int id) {
		return nDao.recupArbitreParId(id);
	}

	@Override
	public void insererArbitre(String nomArbitre, String prenomArbitre) {
		nDao.insererArbitre(new Arbitre(nomArbitre, prenomArbitre));
	}

}
