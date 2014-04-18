package net.sf.gazpachoquest.rest.exception;

import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountNotFoundExceptionHandler implements
		ExceptionMapper<AccountNotFoundException> {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountNotFoundExceptionHandler.class);

	/**
	 * Exception fired from AuthenticationResource
	 */
	@Override
	public Response toResponse(AccountNotFoundException exception) {
		logger.warn("Login access failure: {}", exception.getMessage());
		return Response
				.status(Status.FORBIDDEN)
				.type(MediaType.APPLICATION_JSON)
				.entity(ErrorEntity.with().message(exception.getMessage())
						.build()).build();

	}

}
