package company.api.store.items.exception;

public class InvalidItemActionException extends Exception {

	private static final long serialVersionUID = 1935920075930177205L;

	public InvalidItemActionException(String message) {
		super(message);
	}
}
