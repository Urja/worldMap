package org.worldmap.exception;

public class AtlasDataException extends Exception{

	/**
	 * Class use to handle Atlas data related exceptions
	 * Generally used in AtlasService and GameEngine
	 */
	private static final long serialVersionUID = 1L;
	
	public AtlasDataException(){
		 super();
	}
	
	public AtlasDataException(String mesage) {
		super(mesage);
	}

}
