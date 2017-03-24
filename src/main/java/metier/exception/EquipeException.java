package metier.exception;

public class EquipeException extends Exception {

	private static final long serialVersionUID = -4277749553024753838L;

	public EquipeException() {
		super("Un problème est survenu lors de la création d'une équipe");
	}

	public EquipeException(String arg0) {
		super(arg0);
	}

}
