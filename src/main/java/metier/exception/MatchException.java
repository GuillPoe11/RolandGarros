package metier.exception;

/**
 * Exception lancée lorsque qu'un problème survient lors de la création d'un
 * match
 * 
 * @author eric.poe11
 *
 */
public class MatchException extends Exception {

	private static final long serialVersionUID = -3517697225753923277L;

	public MatchException() {
		super("Un problème est survenu lors de la création du match");
	}

	public MatchException(String message) {
		super(message);
	}

}
