package com.wittybrains.ars.exception;

public class UnauthorizedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UnauthorizedException(String msg) {
		super(msg);
	}

}
