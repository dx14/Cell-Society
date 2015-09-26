
public class NoSimChosen extends Exception {
	public NoSimChosen () {}
	
	public NoSimChosen (String message) {
		super (message);
	}
	
	public NoSimChosen (Throwable cause) {
		super (cause);
	}
	
	public NoSimChosen (String message, Throwable cause) {
		super(message, cause);
	}
}
