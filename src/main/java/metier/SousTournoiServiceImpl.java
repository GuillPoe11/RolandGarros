package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.SousTournoiDao;
import entite.SousTournoi;

@Component
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

}
