package com.wittybrains.ars.exception;

public class ForbiddenException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ForbiddenException(String msg) {
		super(msg);
	}

}
