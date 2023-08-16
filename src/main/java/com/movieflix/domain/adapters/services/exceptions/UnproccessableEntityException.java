package com.movieflix.domain.adapters.services.exceptions;

public class UnproccessableEntityException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnproccessableEntityException(String msg) {
		super(msg);
	}
}
