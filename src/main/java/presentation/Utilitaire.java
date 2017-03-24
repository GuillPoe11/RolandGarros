package presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entite.Arbitre;
import entite.Court;
import entite.Equipe;
import entite.Joueur;
import entite.Match;
import entite.SousTournoi;

public class Utilitaire {

	/**
	 * Permet de remplir une Map utilisée pour afficher le select sur la jsp à
	 * partir d'une liste d'object.
	 * 
	 * @param list
	 *            Une liste d'object
	 * @return La HashMap dont les valeurs sont des chaines de caractères
	 *         correspondant aux libellés des objects et les clés des entiers
	 *         correspondant à l'indice des objects dans la liste entrée en
	 *         paramètre.
	 * @author arnaud.poe11
	 */
	Map<Integer, String> listToMap(List<Object> list) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		for (Object obj : list) {
			switch (obj.getClass().getName()) {
			case "entite.Joueur":
				map.put(((Joueur) obj).getIdJoueur(), ((Joueur) obj).getPrenomJoueur() + ((Joueur) obj).getNomJoueur());
				break;

			case "entite.Equipe":
				map.put(((Equipe) obj).getIdEquipe(),
						((Equipe) obj).getJoueur1().getNomJoueur() + "-" + ((Equipe) obj).getJoueur2().getNomJoueur());
				break;

			case "entite.SousTournoi":
				map.put(((SousTournoi) obj).getIdSousTournoi(), ((SousTournoi) obj).getNomSousTournoi());
				break;

			case "entite.Court":
				map.put(((Court) obj).getIdCourt(), ((Court) obj).getNomCourt());
				break;

			case "entite.Arbitre":
				map.put(((Arbitre) obj).getIdArbitre(),
						((Arbitre) obj).getPrenomArbitre() + ((Arbitre) obj).getNomArbitre());
				break;

			case "entite.Match":
				String str = ((Match) obj).getCourt().getNomCourt();
				if (((Match) obj).getDateMatch() != null) {
					str += ((Match) obj).getDateMatch().toString();
				}
				str += ((Match) obj).getSousTournoi().getNomSousTournoi();
				if (((Match) obj).getScore1() != null) {
					str += ((Match) obj).getScore1();
				}
				if (((Match) obj).getScore2() != null) {
					str += ((Match) obj).getScore2();
				}
				if (((Match) obj).getDureeMatch() != null) {
					str += ((Match) obj).getDureeMatch();
				}
				map.put(((Match) obj).getIdMatch(), str);
				break;

			default:

				/* Action */;
				break;
			}
		}
		return map;
	}

}
