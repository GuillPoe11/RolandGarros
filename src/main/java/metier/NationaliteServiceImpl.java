package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.NationaliteDao;
import entite.Nationalite;

@Component
public class NationaliteServiceImpl implements NationaliteService {

	@Autowired
	private NationaliteDao nDao;

	/*
	 * Constructeurs
	 */
	public NationaliteServiceImpl() {
	}

	/*
	 * (fonction pour recupérer toutes les nationalités)
	 * 
	 */
	public List<Nationalite> recupToutesNationalites() {
		return nDao.recupToutesNationalites();
	}

	/*
	 * (fonction pour recupérer une nationalité par l'id)
	 * 
	 */
	public Nationalite recupNationaliteParId(int id) {
		return nDao.recupNationaliteParId(id);
	}

}
