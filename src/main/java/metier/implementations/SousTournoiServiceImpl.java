package metier.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.interfaces.SousTournoiDao;
import entite.SousTournoi;
import metier.interfaces.SousTournoiService;

@Service
public class SousTournoiServiceImpl implements SousTournoiService {

	@Autowired
	private SousTournoiDao dao;

	public SousTournoiServiceImpl() {
	}

	@Override
	public SousTournoi recupererSousTournoi(String nomSousTournoi) {
		SousTournoi sousTournoiRetour = null;
		for (SousTournoi sousTournoi : dao.recupTousLesSousTournois()) {
			if (sousTournoi.getNomSousTournoi().equals(nomSousTournoi)) {
				sousTournoiRetour = sousTournoi;
			}
		}
		return sousTournoiRetour;
	}

	@Override
	public List<SousTournoi> recupererTousLesSousTournois() {
		return dao.recupTousLesSousTournois();
	}

	@Override
	public SousTournoi recupererSousTournoiParId(int id) {
		return dao.recupSousTournoiParId(id);
	}

	@Override
	public List<SousTournoi> recupererTousLesSousTournoisEquipe() {
		return dao.recupTousLesSousTournoisEquipe();
	}

	@Override
	public List<SousTournoi> recupererTousLesSousTournoisSimple() {
		return dao.recupTousLesSousTournoisSimple();
	}

}
