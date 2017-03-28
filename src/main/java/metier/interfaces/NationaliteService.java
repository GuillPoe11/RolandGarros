package metier.interfaces;

import java.util.List;

import entite.Nationalite;

public interface NationaliteService {

	/**
	 * Fonction qui récupère toutes les nationalités
	 * 
	 * @return List<Nationalite>
	 */
	public List<Nationalite> recupToutesNationalites();

	/**
	 * Fonction qui récupère la nationalité par id
	 * 
	 * @param id
	 * @return Nationalité
	 */
	public Nationalite recupNationaliteParId(int id);

}
