package net.sf.gazpachoquest.rest.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApplicationExceptionHandler implements ExceptionMapper<WebApplicationException> {
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationExceptionHandler.class);

    @Override
    public Response toResponse(WebApplicationException exception) {
        logger.warn("Handled error", exception);
        return exception.getResponse();
    }

}
