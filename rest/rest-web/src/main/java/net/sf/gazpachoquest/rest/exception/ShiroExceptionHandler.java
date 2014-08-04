package net.sf.gazpachoquest.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import net.sf.gazpachoquest.dto.error.ErrorEntity;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroExceptionHandler implements ExceptionMapper<ShiroException> {

    private static final Logger logger = LoggerFactory.getLogger(ShiroExceptionHandler.class);

    @Override
    public Response toResponse(ShiroException exception) {
        logger.warn(exception.getMessage());

        Status status = Status.FORBIDDEN; // Invalid api key
        if (exception instanceof AccountException) {
            // API key missing
            status = Status.BAD_REQUEST;
        } else if (exception instanceof AuthorizationException) {
            // Not enough permissions
            status = Status.UNAUTHORIZED;
        } else {
            logger.error(exception.getMessage(), exception);
        }
        return Response.status(status).type(MediaType.APPLICATION_JSON)
                .entity(ErrorEntity.with().message(exception.getMessage()).build()).build();
    }

}
