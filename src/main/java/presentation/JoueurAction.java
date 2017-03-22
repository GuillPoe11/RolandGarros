package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import entite.Joueur;
import entite.Nationalite;
import metier.JoueurService;
import metier.NationaliteService;

public class JoueurAction extends ActionSupport {

	private static final long serialVersionUID = -2439182379487460604L;

	@Autowired
	private JoueurService joueurService;

	@SuppressWarnings("unused")
	private NationaliteService nationaliteService;

	private Joueur joueur;
	
	private Integer idNationalite;
	private List<Nationalite> lstNationalites;
	private Map<Integer, String> mapNationalites;

	public JoueurAction(@Autowired NationaliteService nationaliteService) {
		lstNationalites = nationaliteService.recupToutesNationalites();
		System.out.println(lstNationalites);
		mapNationalites = listToMap(nationaliteService.recupToutesNationalites());
		System.out.println(mapNationalites.get(1));
	}

	public String creerJoueur() {
		System.out.println(lstNationalites);
		System.out.println(idNationalite);
		Nationalite nationalite = lstNationalites.get(idNationalite);
		joueurService.creerJoueur(joueur.getNomJoueur(), joueur.getPrenomJoueur(), joueur.getSexeJoueur(),
				nationalite);
		return "success";
	}
	
	private Map<Integer, String> listToMap(List<Nationalite> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i = 0;
		for (Nationalite nationalite : list) {
			map.put(i, nationalite.getLibelleNationalite());
			i++;
		}
		return map;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Map<Integer, String> getMapNationalites() {
		return mapNationalites;
	}

	public void setMapNationalites(Map<Integer, String> mapNationalites) {
		this.mapNationalites = mapNationalites;
	}

	public Integer getIdNationalite() {
		return idNationalite;
	}

	public void setIdNationalite(Integer idNationalite) {
		this.idNationalite = idNationalite;
	}

}
