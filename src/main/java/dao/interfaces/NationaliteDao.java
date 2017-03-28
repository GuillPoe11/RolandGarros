package dao.interfaces;

import java.util.List;

import entite.Nationalite;

public interface NationaliteDao {

	/**
	 * Récupération d'une nationalite dans la bdd à partir de son Id
	 * 
	 * @param Integer
	 *            idNationalite
	 * @return la nationalite
	 */

	public Nationalite recupNationaliteParId(Integer idNationalite);

	/**
	 * insertion d'une nationalite dans la bdd
	 * 
	 * @param Equipe
	 *            nationalite a ajouter
	 * 
	 *            ### normalement pas utilisé, sauf si nouveaux pays ?
	 */
	public void insererNationalite(Nationalite n);

	/**
	 * Retourne le contenu de la tableBdd Nationalite
	 */
	public List<Nationalite> recupToutesNationalites();

}
