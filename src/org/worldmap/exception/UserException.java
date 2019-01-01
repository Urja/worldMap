package org.worldmap.exception;

public class UserException  extends Exception{
	/**
	 * Class use to handle User related exceptions
	 * Generally used in UserService
	 */
	private static final long serialVersionUID = 1L;
	public UserException(){
		 super();
	}
	public UserException(String message) {
		super(message);
	}
}
	