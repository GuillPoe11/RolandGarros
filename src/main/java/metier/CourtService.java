package metier;

import java.util.List;

import entite.Court;

public interface CourtService {

	public List<Court> recupTousCourts();

	public Court recupCourtParId(int id);

	public void insererCourt(String nomCourt, String numeroCourt);

}
