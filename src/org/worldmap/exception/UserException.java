package org.worldmap.exception;

/**
 * Class use to handle User related exceptions
 * Generally used in UserService
 */
public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserException(String message) {
		super(message);
	}

	public UserException(String message, Throwable t) {
		super(message, t);
	}
}
	