package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CourtDao;
import entite.Court;

@Service
public class CourtServiceImpl implements CourtService {

	@Autowired
	private CourtDao nDao;

	public CourtServiceImpl() {
	}

	@Override
	public List<Court> recupTousCourts() {
		return nDao.recupTousLesCourts();
	}

	@Override
	public Court recupCourtParId(int id) {
		return nDao.recupCourtParId(id);
	}

	@Override
	public void insererCourt(String nomCourt, String numeroCourt) {
		nDao.insererCourt(new Court(nomCourt, numeroCourt));
	}

	@Override
	public List<Court> recupLesDixDerniersCourts() {
		return nDao.recupLesDixDerniersCourts();
	}

}
