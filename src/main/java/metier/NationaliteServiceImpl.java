package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NationaliteDao;
import entite.Nationalite;

@Service(value = "NationaliteService")
public class NationaliteServiceImpl implements NationaliteService {

	@Autowired
	private NationaliteDao nDao;

	/**
	 * Constructeurs
	 */
	public NationaliteServiceImpl() {
	}

	/**
	 * (fonction pour recupérer toutes les nationalités)
	 * 
	 * @return liste de nationalites
	 * 
	 */
	@Override
	public List<Nationalite> recupToutesNationalites() {
		return nDao.recupToutesNationalites();
	}

	/**
	 * (fonction pour recupérer une nationalité par l'id)
	 * 
	 * @return une nationalite
	 * 
	 */
	@Override
	public Nationalite recupNationaliteParId(int id) {
		return nDao.recupNationaliteParId(id);
	}

}
