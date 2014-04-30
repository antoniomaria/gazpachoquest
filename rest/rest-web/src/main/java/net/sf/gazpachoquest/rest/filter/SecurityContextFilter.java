package net.sf.gazpachoquest.rest.filter;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import net.sf.gazpachoquest.security.shiro.APIKeyToken;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.ext.MessageContext;
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

    @Context
    private MessageContext messageContext;

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
        String apiKey = messageContext.getHttpServletRequest().getParameter("api_key");
        if (StringUtils.isNotBlank(apiKey)) {
            return apiKey;
        }
        apiKey = !headers.getRequestHeader("api_key").isEmpty() ? headers.getRequestHeader("api_key").get(0) : null;
        return apiKey;
    }

}
