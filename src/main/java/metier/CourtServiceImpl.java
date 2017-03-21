package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.CourtDao;
import entite.Court;

@Component
public class CourtServiceImpl implements CourtService {

	@Autowired
	private CourtDao nDao;

	/**
	 * Constructeurs
	 */
	public CourtServiceImpl() {
	}

	/**
	 * (fonction pour recupérer toutes les terrains)
	 * 
	 */
	@Override
	public List<Court> recupTousCourts() {
		return nDao.recupTousLesCourts();
	}

	/**
	 * (fonction pour recupérer un terrain par l'id)
	 * 
	 */
	@Override
	public Court recupCourtParId(int id) {
		return nDao.recupCourtParId(id);
	}

	/**
	 * (fonction pour ajouter un terrain)
	 * 
	 */
	@Override
	public void insererCourt(String nomCourt, String numeroCourt) {
		nDao.insererCourt(new Court(nomCourt, numeroCourt));
	}

}
