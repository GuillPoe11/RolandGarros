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

	/*
	 * Constructeurs
	 */
	public ArbitreServiceImpl() {
	}

	/**
	 * (fonction pour recupérer toutes les Arbitre)
	 * 
	 */
	@Override
	public List<Arbitre> recupTousArbitres() {
		return nDao.recupTousLesArbitres();
	}

	/**
	 * (fonction pour recupérer un Arbitre par l'id)
	 * 
	 */
	@Override
	public Arbitre recupArbitreParId(int id) {
		return nDao.recupArbitreParId(id);
	}

	/**
	 * (fonction pour ajouter un arbitre)
	 * 
	 */
	@Override
	public void insererArbitre(String nomArbitre, String prenomArbitre) {
		nDao.insererArbitre(new Arbitre(nomArbitre, prenomArbitre));
	}

}
