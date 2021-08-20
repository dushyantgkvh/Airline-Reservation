package com.wittybrains.ars.exception;

public class BadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BadRequestException(String msg) {
		super(msg);
	}

}
