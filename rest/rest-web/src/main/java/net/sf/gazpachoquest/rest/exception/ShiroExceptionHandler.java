package net.sf.gazpachoquest.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroExceptionHandler implements ExceptionMapper<ShiroException> {

	private static final Logger logger = LoggerFactory
			.getLogger(ShiroExceptionHandler.class);

	@Override
	public Response toResponse(ShiroException exception) {
		logger.error(exception.getMessage(), exception);
		return Response.status(Status.FORBIDDEN)
				.header("exception", exception.getMessage()).build();
	}

}
