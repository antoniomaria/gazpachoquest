package net.sf.gazpachoquest.rest.filter;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import net.sf.gazpachoquest.security.shiro.APIKeyToken;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityContextFilter implements RequestHandler {

    private static final Logger logger = LoggerFactory.getLogger(SecurityContextFilter.class);

    @Context
    private HttpHeaders headers;

    @Context
    private UriInfo uriInfo;

    @Override
    public Response handleRequest(Message message, ClassResourceInfo resourceClass) {
        String path = uriInfo.getPath();
        logger.debug("New access to resource {}", path);
        if (path.startsWith("auth") || path.contains("api-docs")) {
            // Ignore the AuthenticationResource
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        String apiKey = resolveApiKey();
        AuthenticationToken token = new APIKeyToken.Builder().apiKey(apiKey).build();
        subject.login(token); //
        return null;
    }

    protected String resolveApiKey() {
        List<String> authValues = headers.getRequestHeader("Authorization");
        if (authValues.size() == 0) {
            return null;
        }
        String[] values = authValues.get(0).split(" ");
        if (values.length != 2 || !"GZQ".equals(values[0])) {
            return null;
        }
        return values[1];
    }
}
