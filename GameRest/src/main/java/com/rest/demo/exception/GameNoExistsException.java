package com.rest.demo.exception;

public class GameNoExistsException extends GameKOException {

	public GameNoExistsException(String detalle) {
		super(detalle);
	}

	public GameNoExistsException() {
		super();
	}

	private static final long serialVersionUID = 1L;

}
