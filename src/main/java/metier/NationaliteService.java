package metier;

import java.util.List;

import entite.Nationalite;

public interface NationaliteService {

	public List<Nationalite> recupToutesNationalites();

	public Nationalite recupNationaliteParId(int id);

}
