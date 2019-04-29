package com.asiainfo.rms.gateway.exception;

import org.springframework.security.core.AuthenticationException;

public class AtsAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = -325199668261859419L;

	public AtsAuthenticationException(String msg) {
		super(msg);
	}

}
