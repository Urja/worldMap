package org.worldmap.exception;

/**
 * Class use to handle Atlas data related exceptions
 * Generally used in AtlasService and GameEngine
 */
public class AtlasDataException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AtlasDataException(String message) {
		super(message);
	}

	public AtlasDataException(String message, Throwable t) {
		super(message, t);
	}
}
