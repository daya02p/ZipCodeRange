package com.test.minrange;

public class MinRangeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4679869642576355220L;

	public MinRangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public MinRangeException(String message) {
		super(message);
	}
}
